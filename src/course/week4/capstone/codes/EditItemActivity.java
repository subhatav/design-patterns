package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class EditItemActivity extends AppCompatActivity implements Observer {

  private static final int REQUEST_CODE = 1;

  private Item item;
  private ItemController itemController;

  private Context context;

  private Bitmap image;
  private ImageView photo;
  private Spinner borrowerSpinner;
  private TextView borrowerTv;
  private Switch status;

  private EditText title;
  private EditText maker;
  private EditText desc;
  private EditText length;
  private EditText width;
  private EditText height;
  private EditText invisible;

  private String titleStr;
  private String makerStr;
  private String descStr;
  private String lengthStr;
  private String widthStr;
  private String heightStr;

  private ItemList itemList = new ItemList();
  private ItemListController itemListController = new ItemListController(itemList);

  private ContactList contactList = new ContactList();
  private ContactListController contactListController = new ContactListController(contactList);

  private ArrayAdapter<String> adapter;

  private int position;
  private boolean onCreateUpdate = false;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_item);

    title = (EditText) findViewById(R.id.title);
    maker = (EditText) findViewById(R.id.maker);
    desc = (EditText) findViewById(R.id.desc);
    length = (EditText) findViewById(R.id.length);
    width = (EditText) findViewById(R.id.width);
    height = (EditText) findViewById(R.id.height);
    borrowerSpinner = (Spinner) findViewById(R.id.borrowerSpinner);
    borrowerTv = (TextView) findViewById(R.id.borrowerTv);
    photo = (ImageView) findViewById(R.id.image_view);
    status = (Switch) findViewById(R.id.available_switch);
    invisible = (EditText) findViewById(R.id.invisible);

    invisible.setVisibility(View.GONE);

    position = getIntent().getIntExtra("position", 0);
    context = getApplicationContext();

    itemListController.registerObserver(this);
    itemListController.loadItems(context);

    onCreateUpdate = true;

    contactListController.registerObserver(this);
    contactListController.loadContacts(context);

    onCreateUpdate = false;
  }

  public void saveItem(final View view) {

    titleStr = title.getText().toString();
    makerStr = maker.getText().toString();
    descStr = desc.getText().toString();
    lengthStr = length.getText().toString();
    widthStr = width.getText().toString();
    heightStr = height.getText().toString();

    final Contact contact = null;

    if (!status.isChecked()) {

      final String borrowerStr = borrowerSpinner.getSelectedItem().toString();

      contact = contactListController.getContactByUsername(borrowerStr);
    }

    if (!validateInput()) return;

    final String id = itemController.getId();
    final Item updatedItem = new Item(titleStr, makerStr, descStr, image, id);
    final ItemController updatedItemController = new ItemController(updatedItem);

    updatedItemController.setDimensions(lengthStr, widthStr, heightStr);

    if (!status.isChecked()) {

      updatedItemController.setStatus("Borrowed");
      updatedItemController.setBorrower(contact);
    }

    if (!itemListController.editItem(item, updatedItem, context)) return;

    itemListController.removeObserver(this);

    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

  public void deleteItem(final View view) {

    if (!itemListController.deleteItem(item, context)) return;

    itemListController.removeObserver(this);

    startActivity(new Intent(this, MainActivity.class));
  }

  public boolean validateInput() {

    if (titleStr.equals("")) {

      title.setError("Empty field!");
      return false;
    }

    if (makerStr.equals("")) {

      maker.setError("Empty field!");
      return false;
    }

    if (descStr.equals("")) {

      desc.setError("Empty field!");
      return false;
    }

    if (lengthStr.equals("")) {

      length.setError("Empty field!");
      return false;
    }

    if (widthStr.equals("")) {

      width.setError("Empty field!");
      return false;
    }

    if (heightStr.equals("")) {

      height.setError("Empty field!");
      return false;
    }

    return true;
  }

  public void addPhoto(final View view) {

    final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

    if (intent.resolveActivity(getPackageManager()) != null) {

      startActivityForResult(intent, REQUEST_CODE);
    }
  }

  public void deletePhoto(final View view) {

    image = null;
    photo.setImageResource(android.R.drawable.ic_menu_gallery);
  }

  // Checked == "Available" Unchecked == "Borrowed"

  public void toggleSwitch(final View view) {

    if (status.isChecked()) {

      borrowerSpinner.setVisibility(View.GONE);
      borrowerTv.setVisibility(View.GONE);

      itemController.setBorrower(null);
      itemController.setStatus("Available.");

    } else {

      if (contactList.getSize() == 0) {

        invisible.setEnabled(false);
        invisible.setVisibility(View.VISIBLE);
        invisible.requestFocus();
        invisible.setError("No contacts available! Must add borrower to contacts.");
        status.setChecked(true);

      } else {

        borrowerSpinner.setVisibility(View.VISIBLE);
        borrowerTv.setVisibility(View.VISIBLE);
      }
    }
  }

  public void update() {

    if (onCreateUpdate) {

      adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                                               contactListController.getAllUsernames());

      borrowerSpinner.setAdapter(adapter);

      item = itemListController.getItem(position);
      itemController = new ItemController(item);

      final Contact contact = itemController.getBorrower();

      if (contact != null) {

        borrowerSpinner.setSelection(contactListController.getIndex(contact));
      }

      title.setText(itemController.getTitle());
      maker.setText(itemController.getMaker());
      desc.setText(itemController.getDescription());

      length.setText(itemController.getLength());
      width.setText(itemController.getWidth());
      height.setText(itemController.getHeight());

      final String statusStr = itemController.getStatus();

      if (statusStr.equals("Borrowed")) {

        status.setChecked(false);

      } else {

        borrowerTv.setVisibility(View.GONE);
        borrowerSpinner.setVisibility(View.GONE);
      }

      image = itemController.getImage();

      if (image != null) {

        photo.setImageBitmap(image);

      } else {

        photo.setImageResource(android.R.drawable.ic_menu_gallery);
      }
    }
  }

  @Override
  protected void onActivityResult(final int requestCode,
                                  final int resultCode,
                                  final Intent intent) {

    if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

      image = (Bitmap) intent.getExtras().get("data");

      photo.setImageBitmap(image);
    }
  }
}

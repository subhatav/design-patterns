package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AddItemActivity extends AppCompatActivity {

  private static final int REQUEST_CODE = 1;

  private Context context;

  private ImageView photo;
  private Bitmap image;

  private EditText title;
  private EditText maker;
  private EditText desc;
  private EditText length;
  private EditText width;
  private EditText height;

  private String titleStr;
  private String makerStr;
  private String descriptionStr;
  private String lengthStr;
  private String widthStr;
  private String heightStr;

  private ItemList itemList = new ItemList();
  private ItemListController itemListController = new ItemListController(itemList);

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_item);

    title = (EditText) findViewById(R.id.title);
    maker = (EditText) findViewById(R.id.maker);
    desc = (EditText) findViewById(R.id.desc);
    length = (EditText) findViewById(R.id.length);
    width = (EditText) findViewById(R.id.width);
    height = (EditText) findViewById(R.id.height);
    photo = (ImageView) findViewById(R.id.image_view);

    photo.setImageResource(android.R.drawable.ic_menu_gallery);

    context = getApplicationContext();
    itemListController.loadItems(context);
  }

  public void saveItem(final View view) {

    titleStr = title.getText().toString();
    makerStr = maker.getText().toString();
    descStr = desc.getText().toString();
    lengthStr = length.getText().toString();
    widthStr = width.getText().toString();
    heightStr = height.getText().toString();

    if (!validateInput()) return;

    final Item item = new Item(titleStr, makerStr, descStr, image, null);
    final ItemController itemController = new ItemController(item);

    itemController.setDimensions(lengthStr, widthStr, heightStr);

    if (!itemListController.addItem(item, context)) return;

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

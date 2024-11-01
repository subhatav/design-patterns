package week.fourth.capstone.codes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {

  private ContactList contactList = new ContactList();
  private ContactListController contactListController = new ContactListController(contactList);

  private Context context;

  private EditText username;
  private EditText email;

  private String usernameStr;
  private String emailStr;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);

    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);

    context = getApplicationContext();
    contactListController.loadContacts(context);
  }

  public void saveContact(final View view) {

    usernameStr = username.getText().toString();
    emailStr = email.getText().toString();

    if(!validateInput()) return;

    final Contact contact = new Contact(usernameStr, emailStr, null);

    if (!contactListController.addContact(contact, context)) return;

    finish();
  }

  public boolean validateInput() {

    if (usernameStr.equals("")) {

      username.setError("Empty field!");
      return false;
    }

    if (emailStr.equals("")) {

      email.setError("Empty field!");
      return false;
    }

    if (!emailStr.contains("@")) {

      email.setError("Must be an email address!");
      return false;
    }

    if (!contactListController.isUsernameAvailable(usernameStr)) {

      username.setError("Username already taken!");
      return false;
    }

    return true;
  }
}
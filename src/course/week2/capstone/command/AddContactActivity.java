package com.example.sharingapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import javafx.scene.web.HTMLEditorSkin.Command;

public class AddContactActivity extends AppCompatActivity {

  private Context context;

  private EditText username;
  private EditText email;

  private ContactList contactList = new ContactList();

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_add_contact);

    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);

    context = getApplicationContext();
    contactList.loadContacts(context);
  }

  public void saveContact(final View view) {

    final String usernameStr = username.getText().toString();
    final String emailStr = email.getText().toString();

    if (usernameStr.equals("")) {

      username.setError("Empty field!");
      return;
    }

    if (emailStr.equals("")) {

      email.setError("Empty field!");
      return;
    }

    if (!emailStr.contains("@")) {

      email.setError("Must be an email address!");
      return;
    }

    if (!contactList.isUsernameAvailable(usernameStr)) {

      username.setError("Username already taken!");
      return;
    }

    final Contact contact = new Contact(usernameStr, emailStr, null);
    final Command command = new AddContactCommand(contactList, contact, context);

    command.execute();

    if (!command.isExecuted()) {

      return;
    }

    finish();
  }
}


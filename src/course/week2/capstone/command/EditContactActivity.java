package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditContactActivity extends AppCompatActivity {

  private Context context;
  private Contact contact;

  private EditText email;
  private EditText username;

  private ContactList contactList = new ContactList();

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_contact);

    context = getApplicationContext();
    contactList.loadContacts(context);

    contact = contactList.getContact(getIntent().getIntExtra("position", 0));

    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);

    username.setText(contact.getUsername());
    email.setText(contact.getEmail());
  }

  public void saveContact(final View view) {

    final String emailStr = email.getText().toString();
    final String usernameStr = username.getText().toString();

    if (emailStr.equals("")) {

      email.setError("Empty field!");
      return;
    }

    if (!emailStr.contains("@")) {

      email.setError("Must be an email address!");
      return;
    }

    if (!contactList.isUsernameAvailable(usernameStr) &&
        !(contact.getUsername().equals(usernameStr))) {

      username.setError("Username already taken!");
      return;
    }

    final String contactId = contact.getId();

    final Contact updatedContact = new Contact(usernameStr, emailStr, contactId);
    final Command command = new EditContactCommand(contactList, contact, updatedContact, context);

    command.execute();

    if (!command.isExecuted()) {

      return;
    }

    finish();
  }

  public void deleteContact(final View view) {

    final Command command = new DeleteContactCommand(contactList, contact, context);

    command.execute();

    if (!command.isExecuted()) {

      return;
    }

    finish();
  }
}

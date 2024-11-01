package com.example.sharingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Observer;

// [Note] User should NOT be able to EDIT Contacts which are `active` borrowers.

public class EditContactActivity extends AppCompatActivity implements Observer {

  private ContactList contactList = new ContactList();
  private ContactListController contactListController = new ContactListController(contactList);

  private Context context;

  private Contact contact;
  private ContactController contactController = new ContactController(contact);

  private EditText email;
  private EditText username;

  @Override
  protected void onCreate(final Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    contactListController.registerObserver(this);

    setContentView(R.layout.activity_edit_contact);

    context = getApplicationContext();
    contactListController.loadContacts(context);

    contact = contactListController.getContact(getIntent().getIntExtra("position", 0));

    username = (EditText) findViewById(R.id.username);
    email = (EditText) findViewById(R.id.email);

    username.setText(contact.getUsername());
    email.setText(contact.getEmail());
  }

  @Override
  protected void onDestroy() {

    super.onDestroy();
    contactListController.removeObserver(this);
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

    if (!contactListController.isUsernameAvailable(usernameStr) &&
        !contactController.getUsername().equals(usernameStr)) {

      username.setError("Username already taken!");
      return;
    }

    final String contactId = contactController.getId();
    final Contact updatedContact = new Contact(usernameStr, emailStr, contactId);

    if (!contactListController.editContact(contact, updatedContact, context)) return;

    finish();
  }

  public void deleteContact(final View view) {

    if (!contactListController.deleteContact(contact, context)) return;

    finish();
  }
}

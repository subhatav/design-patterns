package com.example.sharingapp;

import android.content.Context;

public class AddContactCommand extends Command {

  private final ContactList contactList;

  private final Contact contact;
  private final Context context;

  public AddContactCommand(final ContactList contactList,
            final Contact contact, final Context context) {

    this.contactList = contactList;

    this.contact = contact;
    this.context = context;
  }

  @Override
  public void execute() {

    contactList.addContact(contact);
    setIsExecuted(contactList.saveContacts(context));
  }
}

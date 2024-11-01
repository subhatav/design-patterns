package com.example.sharingapp;

import android.content.Context;

public class DeleteContactCommand extends Command {

  private final ContactList contactList;

  private final Contact contact;
  private final Context context;

  public DeleteContactCommand(final ContactList contactList,
               final Contact contact, final Context context) {

    this.contactList = contactList;

    this.contact = contact;
    this.context = context;
  }

  @Override
  public void execute() {

    contactList.deleteContact(contact);
    setIsExecuted(contactList.saveContacts(context));
  }
}

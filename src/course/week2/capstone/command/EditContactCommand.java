package com.example.sharingapp;

import android.content.Context;

public class EditContactCommand extends Command {

  private final ContactList contactList;

  private final Contact oldContact;
  private final Contact freshContact;

  private Context context;

  public EditContactCommand(final ContactList contactList, final Contact oldContact,
                            final Contact freshContact, final Context context) {

    this.contactList = contactList;

    this.oldContact = oldContact;
    this.freshContact = freshContact;

    this.context = context;
  }

  @Override
  public void execute() {

    contactList.deleteContact(oldContact);
    contactList.addContact(freshContact);

    setIsExecuted(contactList.saveContacts(context));
  }
}

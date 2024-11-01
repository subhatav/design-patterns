package com.example.sharingapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Observer;

public class ContactListController {

  private ContactList contactList;

  public ContactListController(final ContactList contactList) {

    this.contactList = contactList;
  }

  public int getSize() {

    return contactList.getSize();
  }

  public int getIndex(final Contact contact) {

    return contactList.getIndex(contact);
  }

  public List<Contact> getContacts() {

    return contactList.getContacts();
  }

  public void setContacts(final List<Contact> contactList) {

    this.contactList.setContacts(contactList);
  }

  public boolean isUsernameAvailable(final String username) {

    return contactList.isUsernameAvailable(username);
  }

  public List<String> getAllUsernames() {

    return contactList.getAllUsernames();
  }

  public boolean hasContact(final Contact contact) {

    return contactList.hasContact(contact);
  }

  public Contact getContact(final int index) {

    return contactList.getContact(index);
  }

  public Contact getContactByUsername(final String username) {

    return contactList.getContactByUsername(username);
  }

  public boolean addContact(final Contact contact, final Context context) {

    final Command contactCommand;

    contactCommand = new AddContactCommand(contactList, contact, context);
    contactCommand.execute();

    return contactCommand.isExecuted();
  }

  public boolean editContact(final Contact oldContact,
                             final Contact freshContact,
                             final Context context) {

    final Command contactCommand;

    contactCommand = new EditContactCommand(contactList, oldContact, freshContact, context);
    contactCommand.execute();

    return contactCommand.isExecuted();
  }

  public boolean deleteContact(final Contact contact, final Context context) {

    final Command contactCommand;

    contactCommand = new DeleteContactCommand(contactList, contact, context);
    contactCommand.execute();

    return contactCommand.isExecuted();
  }

  public void loadContacts(final Context context) {

    contactList.loadContacts(context);
  }

  public void registerObserver(final Observer observer) {

    contactList.registerObserver(observer);
  }

  public void removeObserver(final Observer observer) {

    contactList.removeObserver(observer);
  }
}

package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ContactList extends Observable {

  private static final String FILENAME = "contacts.sav";

  private static List<Contact> contacts;

  public ContactList() {

    contacts = new ArrayList<>();
  }

  public int getSize() {

    return contacts.size();
  }

  public int getIndex(final Contact current) {

    int position = 0;

    for (final Contact contact : contacts) {

      if (current.getId().equals(contact.getId())) {

        return position;
      }

      position = position + 1;
    }

    return -1;
  }

  public List<Contact> getContacts() {

    return contacts;
  }

  public void setContacts(final List<Contact> contacts) {

    ContactList.contacts = contacts;

    notifyObservers();
  }

  public boolean isUsernameAvailable(final String username) {

    for (final Contact contact : contacts) {

      if (contact.getUsername().equals(username)) {

        return false;
      }
    }

    return true;
  }

  public List<String> getAllUsernames() {

    final List<String> usernames = new ArrayList<>();

    for (final Contact contact : contacts) {

      usernames.add(contact.getUsername());
    }

    return usernames;
  }


  public boolean hasContact(final Contact current) {

    for (final Contact contact : contacts) {

      if (current.getId().equals(contact.getId())) {

        return true;
      }
    }

    return false;
  }

  public Contact getContact(final int index) {

    return contacts.get(index);
  }

  public Contact getContactByUsername(final String username) {

    for (final Contact contact : contacts) {

      if (contact.getUsername().equals(username)) {

        return contact;
      }
    }

    return null;
  }

  public void addContact(final Contact contact) {

    contacts.add(contact);

    notifyObservers();
  }

  public void deleteContact(final Contact contact) {

    contacts.remove(contact);

    notifyObservers();
  }

  public void loadContacts(final Context context) {

    try {

      final FileInputStream fis = context.openFileInput(FILENAME);
      final InputStreamReader isr = new InputStreamReader(fis);
      final Gson gson = new Gson();

      final Type listType = new TypeToken<ArrayList<Contact>>() {
      }.getType();

      contacts = gson.fromJson(isr, listType);

      fis.close();

    } catch (final FileNotFoundException fnfExc) {

      contacts = new ArrayList<>();

    } catch (final IOException ioExc) {

      contacts = new ArrayList<>();
    }

    notifyObservers();
  }

  public boolean saveContacts(final Context context) {

    try {

      final FileOutputStream fos = context.openFileOutput(FILENAME, 0);
      final OutputStreamWriter osw = new OutputStreamWriter(fos);
      final Gson gson = new Gson();

      gson.toJson(contacts, osw);
      osw.flush();
      fos.close();

    } catch (final FileNotFoundException fnfExc) {

      fnfExc.printStackTrace();
      return false;

    } catch (final IOException ioExc) {

      ioExc.printStackTrace();
      return false;
    }

    return true;
  }
}

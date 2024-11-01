package com.example.sharingapp;

import java.util.Observer;

public class ContactController {

  private Contact contact;

  public ContactController(final Contact contact) {

    this.contact = contact;
  }

  public String getId() {

    return contact.getId();
  }

  public void setId() {

    contact.setId();
  }

  public String getUsername() {

    return contact.getUsername();
  }

  public void setUsername(final String username) {

    contact.setUsername(username);
  }

  public String getEmail() {

    return contact.getEmail();
  }

  public void setEmail(final String email) {

    contact.setEmail(email);
  }

  public void registerObserver(final Observer observer) {

    contact.addObserver(observer);
  }

  public void removeObserver(final Observer observer) {

    contact.deleteObserver(observer);
  }
}

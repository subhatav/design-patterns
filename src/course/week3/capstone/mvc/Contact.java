package com.example.sharingapp;

import java.util.Observable;
import java.util.UUID;

public class Contact extends Observable {

  private String username;
  private String email;
  private String id;

  public Contact(final String username, final String email, final String id) {

    this.username = username;
    this.email = email;

    if (id == null) {

      setId();

    } else {

      updateId(id);
    }
  }

  public String getId() {

    return this.id;
  }

  public void setId() {

    this.id = UUID.randomUUID().toString();

    notifyObservers();
  }

  public void updateId(final String id) {

    this.id = id;

    notifyObservers();
  }

  public String getUsername() {

    return username;
  }

  public void setUsername(final String username) {

    this.username = username;

    notifyObservers();
  }

  public String getEmail() {

    return email;
  }

  public void setEmail(final String email) {

    this.email = email;

    notifyObservers();
  }
}

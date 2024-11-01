package course.week2.ungraded.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel implements Subject {

  private final List<Observer> observers = new ArrayList<>();

  private String channelName;
  private String status;

  public Channel(final String channelName, final String status) {

    this.channelName = channelName;
    this.status = status;
  }

  public String getChannelName() {

    return channelName;
  }

  public void setChannelName(final String channelName) {

    this.channelName = channelName;
  }

  public String getStatus() {

    return status;
  }

  public void setStatus(final String status) {

    this.status = status;

    notifyObservers();
  }

  @Override
  public void registerObserver(final Observer observer) {

    observers.add(observer);
  }

  @Override
  public void unregisterObserver(final Observer observer) {

    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {

    observers.forEach(observer -> observer.update(status));
  }
}

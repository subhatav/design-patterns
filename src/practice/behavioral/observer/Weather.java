package practice.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class Weather implements Subject {

  private final List<Observer> observers = new ArrayList<>();
  private WeatherType currentWeatherType = WeatherType.CLEAR;

  @Override
  public void attach(@NonNull final Observer watcher) {
    log.info("ATTACHING Observer => [" + watcher + "]");
    observers.add(watcher); // Add OBSERVER to current LIST
  }

  @Override
  public void detach(@NonNull final Observer watcher) {
    log.info("DETACHING Observer => [" + watcher + "]");
    observers.remove(watcher); // Remove OBSERVER from LIST
  }

  @Override
  public void notifyObservers() {
    log.info("Notifying ALL Observers => " + observers);
    observers.forEach(watcher -> watcher.update(currentWeatherType));
  }

  public void advanceTime() {
    log.info("CURRENT Weather TYPE => [" + currentWeatherType + "]");
    currentWeatherType = getFreshWeatherType(WeatherType.values());
    log.info("CHANGED Weather TYPE => [" + currentWeatherType + "]");
    notifyObservers(); // Update ALL Watchers of CHANGE in Weather
  }

  private WeatherType getFreshWeatherType(@NonNull final WeatherType[] weatherTypeValues) {
    return weatherTypeValues[(currentWeatherType.ordinal() + 1) % weatherTypeValues.length];
  }
}

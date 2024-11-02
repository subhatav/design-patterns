package practice.behavioral.observer;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class OrcBand implements Observer {

  @Override
  public void update(@NonNull final WeatherType weatherType) {
    final var groupName = getClass().getSimpleName(); // Retrieves CURRENT Group Name
    log.info("WEATHER for <" + groupName + "> Watchers => [" + weatherType + "]");
  }
}

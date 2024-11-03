package practice.behavioral.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class SwitchButton {

  @NonNull
  private final String location;
  private boolean state = false;

  public void toggleState() {
    state = !state;
  }

  public void printState() {
    var isOn = state ? "ON" : "OFF"; // Determine CURRENT state of Switch
    log.info("State of <" + location + "> Switch => [" + isOn + "]");
  }
}

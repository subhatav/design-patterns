package practice.behavioral.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class SwitchTask {

  @NonNull
  private final SwitchButton switcher;

  public void execute() {
    switcher.toggleState();
    switcher.printState();
  }
}

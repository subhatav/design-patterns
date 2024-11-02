package practice.behavioral.template;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public abstract sealed class HackStyle permits BruteHack, SubtleHack {

  protected abstract String chooseTarget();

  protected abstract void confuseTarget(@NonNull final String target);

  protected abstract void stealResource(@NonNull final String target);

  public final void hack() {
    final var target = chooseTarget(); // PLUCK Target
    log.info("PICKED Target => [" + target + "]");
    confuseTarget(target); // DISTRACT away Target
    stealResource(target); // ROB wanted Resource
  }
}

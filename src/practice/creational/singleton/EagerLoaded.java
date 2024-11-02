package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EagerLoaded {

  private static final EagerLoaded INSTANCE = new EagerLoaded();

  public static EagerLoaded getInstance() {
    return INSTANCE;
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

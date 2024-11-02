package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LazyLoaded {

  private static LazyLoaded instance;

  public static LazyLoaded getInstance() {
    if (instance == null) {
      instance = new LazyLoaded();
    }
    return instance; // Return SAME Object
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

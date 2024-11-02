package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DoubleCheckLock {

  // `volatile` => ATOMIC Access by RACING Threads
  private static volatile DoubleCheckLock instance;

  public static DoubleCheckLock getInstance() {
    if (instance == null) {
      synchronized (DoubleCheckLock.class) {
        if (instance == null) {
          instance = new DoubleCheckLock();
        }
      }
    }
    return instance; // Return SAME Object
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

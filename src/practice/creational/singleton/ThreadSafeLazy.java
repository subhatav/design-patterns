package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ThreadSafeLazy {

  // `volatile` => ATOMIC Access by RACING Threads
  private static volatile ThreadSafeLazy instance;

  public static synchronized ThreadSafeLazy getInstance() {
    if (instance == null) {
      instance = new ThreadSafeLazy();
    }
    return instance; // Return SAME Object
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

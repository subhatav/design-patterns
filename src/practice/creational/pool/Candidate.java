package practice.creational.pool;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class Candidate {

  private static final AtomicInteger counter = new AtomicInteger(0);

  @NonNull
  private final int id;

  public Candidate() {
    id = counter.incrementAndGet();
    try {
      Thread.sleep(100L); // TIME to BIRTH
    } catch (final InterruptedException exception) {
      log.warning(exception.getLocalizedMessage());
    }
  }

  public void print() {
    log.info("INSTANCE from Pool => [" + this + "]");
  }
}

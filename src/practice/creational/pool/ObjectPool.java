package practice.creational.pool;

import java.util.HashSet;
import java.util.LinkedHashSet;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public abstract sealed class ObjectPool<T> permits PersonPool {

  private final LinkedHashSet<T> free = new LinkedHashSet<>();
  private final HashSet<T> beingUsed = new HashSet<>();

  protected abstract T create();

  public synchronized T borrow() {
    if (free.isEmpty()) { // CHECKS availability inside `Available` pool
      log.info("Creating FRESHLY since `Available` pool is empty!");
      free.addLast(create()); // ADDS fresh at END into `Available` pool
    }
    log.info("Lending SINGLE from `Available` into `Occupied` pool...");
    final var instance = free.removeFirst(); // TAKES from `Occupied` pool
    beingUsed.add(instance); // REGISTERS `instance` into `Available` pool
    return instance; // LENDS `instance` object to be CONSUMED by any USER
  }

  public synchronized void remit(@NonNull final T instance) {
    log.info("Restoring BACK into `Available` from `Occupied` pool...");
    beingUsed.remove(instance); // DETACHES `instance` from `Occupied` pool
    free.addLast(instance); // ADDS `instance` at END into `Available` pool
  }

  public synchronized void status() {
    final String nbAvailableItems = "nbAvailableItems=" + free.size();
    final String nbOccupiedItems = "nbOccupiedItems=" + beingUsed.size();
    final var nbTotalItems = "[" + nbAvailableItems + ", " + nbOccupiedItems + "]";
    log.info("Pool STATUS => " + nbTotalItems); // Prints CURRENT pool STATUS
  }
}

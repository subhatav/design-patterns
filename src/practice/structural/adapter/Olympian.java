package practice.structural.adapter;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Olympian {

  @NonNull
  private final RowingBoat boat;

  public void rowBoat() {
    log.info("ATHLETE in Rowing => [" + this + "]");
    boat.row(); // ROW currently AVAILABLE type of BOAT
  }
}

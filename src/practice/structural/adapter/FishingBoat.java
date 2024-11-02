package practice.structural.adapter;

import lombok.EqualsAndHashCode;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
public final class FishingBoat {

  public void sail() {
    log.info("Sailing BOAT => [" + this + "]");
  }
}

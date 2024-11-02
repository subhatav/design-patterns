package practice.structural.adapter;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class BoatAdapter implements RowingBoat {

  private final FishingBoat boat = new FishingBoat();

  @Override
  public void row() {
    boat.sail();
  }
}

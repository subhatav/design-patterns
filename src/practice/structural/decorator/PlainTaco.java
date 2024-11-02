package practice.structural.decorator;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class PlainTaco implements TacoRecipe {

  private static final Float MULTIPLIER = 1.0F;

  @Override
  public float getCost() {
    return BASE_PRICE * MULTIPLIER;
  }

  @Override
  public void printCost() {
    log.info("PLAIN Taco [" + this + "] COST => INR " + getCost());
  }
}

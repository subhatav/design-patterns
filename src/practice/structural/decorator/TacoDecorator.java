package practice.structural.decorator;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public abstract sealed class TacoDecorator implements TacoRecipe permits ChickenTaco, FriedTaco {

  @NonNull
  protected final TacoRecipe taco; // TACO to be DECORATED according to SPECIFIC implementations

  @Override
  public void printCost() {
    log.info("DECORATED Taco [" + this + "] COST => INR " + getCost());
  }
}

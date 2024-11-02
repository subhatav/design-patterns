package practice.creational.factory;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class BronzeCoin implements MetalCoin {

  private static final Integer PRINCIPAL_COST = 2_500;

  @NonNull
  private final Float demandFactor; // Price MULTIPLIER

  @Override
  public void printWorth() {
    final var value = (PRINCIPAL_COST * demandFactor) + " INR";
    log.info("Monetary WORTH of BRONZE Coin => " + value);
  }
}

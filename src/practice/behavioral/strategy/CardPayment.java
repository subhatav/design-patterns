package practice.behavioral.strategy;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class CardPayment implements PaymentStrategy {

  @NonNull
  private final String cardDetails;

  @Override
  public void pay(@NonNull final int amount) {
    log.info("PAID Amount => " + amount + " USD");
  }
}

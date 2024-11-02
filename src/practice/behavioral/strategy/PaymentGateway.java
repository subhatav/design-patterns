package practice.behavioral.strategy;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@Setter
@ToString
@EqualsAndHashCode
public final class PaymentGateway {

  @NonNull
  private PaymentStrategy strategy;

  public void checkout(@NonNull final int amount) {
    log.info("SELECTED Strategy => " + strategy);
    strategy.pay(amount); // EXECUTE specific Strategy
  }
}

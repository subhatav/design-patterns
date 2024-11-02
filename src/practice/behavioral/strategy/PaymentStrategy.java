package practice.behavioral.strategy;

import lombok.NonNull;

@FunctionalInterface
public interface PaymentStrategy {

  void pay(@NonNull final int amount);
}

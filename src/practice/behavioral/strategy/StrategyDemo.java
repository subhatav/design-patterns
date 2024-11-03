package practice.behavioral.strategy;

/**
 * Example of Strategy Design Pattern
 */
public final class StrategyDemo {

  public static void main(final String... arguments) {

    final var gateway = new PaymentGateway(); // SAME Gateway

    gateway.setStrategy(new CashPayment("wallet"));
    gateway.checkout(1_000); // Make PAYMENT with CASH

    gateway.setStrategy(new CardPayment("bank-card"));
    gateway.checkout(10_000); // Enact PAYMENT with CARD

    gateway.setStrategy(new CryptoPayment("exchange"));
    gateway.checkout(100_000); // Execute PAYMENT with CRYPTO
  }
}

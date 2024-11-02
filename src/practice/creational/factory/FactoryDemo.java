package practice.creational.factory;

import java.util.List;

/**
 * Example of Factory Method Design Pattern
 */
public final class FactoryDemo {

  public static void main(final String... arguments) {

    createCoinMints().forEach(coinFactory -> {
      coinFactory.mintCoin(CoinType.BRONZE).printWorth();
      coinFactory.mintCoin(CoinType.SILVER).printWorth();
    });
  }

  private static List<CoinFactory> createCoinMints() {
    return List.of(new MassFactory(), new RareFactory());
  }
}

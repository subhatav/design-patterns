package practice.creational.notional;

import java.util.Arrays;
import java.util.List;
import practice.creational.factory.CoinFactory;
import practice.creational.factory.CoinType;

/**
 * Example of Abstract Factory Design Pattern
 */
public final class AbstractDemo {

  public static void main(final String... arguments) {

    createCoinFactories().forEach(coinFactory -> {
      coinFactory.mintCoin(CoinType.BRONZE).printWorth();
      coinFactory.mintCoin(CoinType.SILVER).printWorth();
    });
  }

  private static List<CoinFactory> createCoinFactories() {
    final var factoryTypes = FactoryType.values(); // LIST of Factory TYPES
    return Arrays.stream(factoryTypes).map(FactoryMaker::makeMint).toList();
  }
}

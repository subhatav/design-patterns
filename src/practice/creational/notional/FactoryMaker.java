package practice.creational.notional;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;
import practice.creational.factory.CoinFactory;

@Log
@ToString
@UtilityClass
@EqualsAndHashCode
public final class FactoryMaker {

  public static CoinFactory makeMint(@NonNull final FactoryType factoryType) {
    final CoinFactory coinFactory = factoryType.getCreator().get(); // Creation
    log.info("CATEGORY of Coin Minting FACTORY => [" + coinFactory + "]");
    return coinFactory; // Return the SPECIFIC category of COIN minting FACTORY
  }
}

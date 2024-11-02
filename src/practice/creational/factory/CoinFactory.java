package practice.creational.factory;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
public abstract sealed class CoinFactory permits MassFactory, RareFactory {

  protected abstract Float getDemandFactor(); // Get SPECIFIC multiplier

  public MetalCoin mintCoin(@NonNull final CoinType coinType) {
    var mintedCoin = coinType.getCreator().apply(getDemandFactor());
    log.info("CATEGORY of Minted COIN => [" + mintedCoin + "]");
    return mintedCoin; // Return the SPECIFIC category of minted COIN
  }
}

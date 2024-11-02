package practice.creational.factory;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@NoArgsConstructor
public final class MassFactory extends CoinFactory {

  private static final Float DEMAND_FACTOR = 1.2F;

  @Override
  protected Float getDemandFactor() {
    return DEMAND_FACTOR;
  }

  @Override
  public MetalCoin mintCoin(@NonNull final CoinType coinType) {
    log.info("Current FACTORY for MINT => [" + this + "]");
    return super.mintCoin(coinType); // Get CURRENT minted COIN
  }
}

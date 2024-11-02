package practice.creational.factory;

import java.util.function.Function;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CoinType {

  BRONZE(BronzeCoin::new), // Holds CONSTRUCTOR
  SILVER(SilverCoin::new); // Holds CONSTRUCTOR

  @NonNull
  private final Function<Float, MetalCoin> creator;
}

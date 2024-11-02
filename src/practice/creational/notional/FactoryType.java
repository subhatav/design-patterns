package practice.creational.notional;

import java.util.function.Supplier;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import practice.creational.factory.CoinFactory;
import practice.creational.factory.MassFactory;
import practice.creational.factory.RareFactory;

@Getter
@RequiredArgsConstructor
public enum FactoryType {

  MASS(MassFactory::new), // Holds CONSTRUCTOR
  RARE(RareFactory::new); // Holds CONSTRUCTOR

  @NonNull
  private final Supplier<CoinFactory> creator;
}

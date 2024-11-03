package practice.creational.builder;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class CustomPizza {

  @NonNull
  private final PizzaElement.DoughType doughType;
  @NonNull
  private final PizzaElement.SauceType sauceType;
  @NonNull
  private final PizzaElement.ToppingType topping;

  public void eatPizza() {
    log.info("EATING the Pizza => [" + this + "]");
  }

  @Setter
  @ToString
  @EqualsAndHashCode
  @RequiredArgsConstructor
  @Accessors(chain = true)
  protected static final class PizzaChef {

    @NonNull
    private final PizzaElement.DoughType doughType;

    private PizzaElement.SauceType sauceType;
    private PizzaElement.ToppingType topping;

    public CustomPizza cookPizza() {
      log.info("COOKING the Pizza => [" + this + "]");
      return new CustomPizza(doughType, sauceType, topping);
    }
  }
}

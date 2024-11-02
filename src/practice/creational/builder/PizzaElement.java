package practice.creational.builder;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class PizzaElement {

  protected enum DoughType {

    BAKED, CROSS
  }

  protected enum SauceType {

    HOT, MILD
  }

  protected enum ToppingType {

    CAPSICUM_MUSHROOM, CHEESE_CORN_TOMATO
  }
}

package practice.creational.builder;

import practice.creational.builder.CustomPizza.PizzaChef;
import practice.creational.builder.PizzaElement.DoughType;
import practice.creational.builder.PizzaElement.SauceType;
import practice.creational.builder.PizzaElement.ToppingType;

/**
 * Example of Builder Design Pattern
 */
public final class BuilderDemo {

  public static void main(final String... arguments) {

    new PizzaChef(DoughType.BAKED).setSauceType(SauceType.HOT)
        .setTopping(ToppingType.CAPSICUM_MUSHROOM).cookPizza().eatPizza();

    new PizzaChef(DoughType.CROSS).setSauceType(SauceType.MILD)
        .setTopping(ToppingType.CHEESE_CORN_TOMATO).cookPizza().eatPizza();
  }
}

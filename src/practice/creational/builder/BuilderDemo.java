package practice.creational.builder;

import practice.creational.builder.CustomPizza.PizzaChef;

/**
 * Example of Builder Design Pattern
 */
public final class BuilderDemo {

  public static void main(final String... arguments) {

    new PizzaChef(PizzaElement.DoughType.BAKED).setSauceType(PizzaElement.SauceType.HOT)
        .setTopping(PizzaElement.ToppingType.CAPSICUM_MUSHROOM).cookPizza().eatPizza();

    new PizzaChef(PizzaElement.DoughType.CROSS).setSauceType(PizzaElement.SauceType.MILD)
        .setTopping(PizzaElement.ToppingType.CHEESE_CORN_TOMATO).cookPizza().eatPizza();
  }
}

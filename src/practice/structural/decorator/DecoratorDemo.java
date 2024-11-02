package practice.structural.decorator;

/**
 * Example of Decorator Design Pattern
 */
public final class DecoratorDemo {

  public static void main(final String... arguments) {

    final var plainTaco = new PlainTaco();
    plainTaco.printCost(); // Cook PLAIN

    final var friedTaco = new FriedTaco(plainTaco);
    friedTaco.printCost(); // Decorate FRIED Taco

    final var chickenTaco = new ChickenTaco(friedTaco);
    chickenTaco.printCost(); // Decorate CHICKEN Taco
  }
}

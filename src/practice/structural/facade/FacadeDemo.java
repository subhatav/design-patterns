package practice.structural.facade;

/**
 * Example of Facade Design Pattern
 */
public final class FacadeDemo {

  public static void main(final String... arguments) {

    final var facade = new MineFacade();

    facade.startDay(); // First sequence
    facade.digOutGold(); // Second series
    facade.endDay(); // Third sequence
  }
}

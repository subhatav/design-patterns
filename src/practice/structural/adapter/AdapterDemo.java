package practice.structural.adapter;

/**
 * Example of Adapter Design Pattern
 */
public final class AdapterDemo {

  public static void main(final String... arguments) {

    new Olympian(new BoatAdapter()).rowBoat(); // Play
  }
}

package practice.structural.bridge;

/**
 * Example of Bridge Design Pattern
 */
public final class BridgeDemo {

  public static void main(final String... arguments) {

    final var specialDagger = new Dagger(new PoisonEffect());

    specialDagger.wield(); // WIELD `Dagger` with `PoisonEffect`
    specialDagger.use(); // USING `Dagger` with `PoisonEffect`
    specialDagger.sheath(); // SHEATH `Dagger` with `PoisonEffect`

    final var specialHammer = new Hammer(new BleedEffect());

    specialHammer.wield(); // WIELD `Hammer` with `BleedEffect`
    specialHammer.use(); // USING `Hammer` with `BleedEffect`
    specialHammer.sheath(); // SHEATH `Hammer` with `BleedEffect`
  }
}

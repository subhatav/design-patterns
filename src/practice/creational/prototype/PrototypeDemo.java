package practice.creational.prototype;

/**
 * Example of Prototype Design Pattern
 */
public final class PrototypeDemo {

  public static void main(final String[] arguments) {

    final var knifeWeapon1 = new Knife("butterfly");
    final var rifleWeapon1 = new Rifle("dragunov");

    knifeWeapon1.printWeaponDescription(); // Location of `object`
    rifleWeapon1.printWeaponDescription(); // Location of `object`

    final var knifeWeapon2 = knifeWeapon1.copy(); // Cloned `object`
    final var rifleWeapon2 = rifleWeapon1.copy(); // Cloned `object`

    knifeWeapon2.printWeaponDescription(); // Location of `object`
    rifleWeapon2.printWeaponDescription(); // Location of `object`
  }
}

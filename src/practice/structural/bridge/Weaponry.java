package practice.structural.bridge;

public sealed interface Weaponry permits Dagger, Hammer {

  void wield(); // Abstraction of WIELDING Weaponry

  void use(); // Abstraction of USING Weaponry

  void sheath(); // Abstraction of SHEATHING Weaponry
}

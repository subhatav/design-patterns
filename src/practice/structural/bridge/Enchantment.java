package practice.structural.bridge;

public sealed interface Enchantment permits BleedEffect, PoisonEffect {

  void activate(); // Abstraction of ACTIVATING Enchantment

  void apply(); // Abstraction of APPLYING Enchantment

  void deactivate(); // Abstraction of DEACTIVATING Enchantment
}

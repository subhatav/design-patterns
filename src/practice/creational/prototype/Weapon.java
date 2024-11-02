package practice.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract sealed class Weapon extends Prototype<Weapon> permits Knife, Rifle {

  public abstract void printWeaponDescription(); // Make DIFFERENT types of WEAPONS
}

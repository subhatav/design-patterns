package practice.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

@Log
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public final class Knife extends Weapon {

  @NonNull
  private final String name;

  @Override
  public void printWeaponDescription() {
    final var className = this.getClass().getSimpleName(); // CURRENT Weapon NAME
    log.info("Object of <" + name + "> " + className + " => [" + this + "]");
  }
}

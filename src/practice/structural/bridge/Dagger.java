package practice.structural.bridge;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Dagger implements Weaponry {

  @NonNull
  private final Enchantment enchantment;

  @Override
  public void wield() {
    log.info("WIELDED Weapon => [" + this + "]");
    enchantment.activate(); // ACTIVATE current Spell
  }

  @Override
  public void use() {
    log.info("USING Weapon => [" + this + "]");
    enchantment.apply(); // CAST this current Spell
  }

  @Override
  public void sheath() {
    log.info("SHEATHED Weapon => [" + this + "]");
    enchantment.deactivate(); // DEACTIVATE this Spell
  }
}

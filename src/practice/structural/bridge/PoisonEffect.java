package practice.structural.bridge;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@ToString(callSuper = true)
public final class PoisonEffect implements Enchantment {

  @Override
  public void activate() {
    log.info("ACTIVATED Enchantment => [" + this + "]");
  }

  @Override
  public void apply() {
    log.info("APPLIED Enchantment => [" + this + "]");
  }

  @Override
  public void deactivate() {
    log.info("DEACTIVATED Enchantment => [" + this + "]");
  }
}

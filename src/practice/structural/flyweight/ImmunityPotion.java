package practice.structural.flyweight;

import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
public final class ImmunityPotion implements MagicPotion {

  @Override
  public void drink() {
    log.info("Drinking => IMMUNITY Potion [" + hashCode() + "]");
  }
}
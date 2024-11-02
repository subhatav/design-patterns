package practice.structural.flyweight;

import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
public final class HealingPotion implements MagicPotion {

  @Override
  public void drink() {
    log.info("Drinking => HEALING Potion [" + hashCode() + "]");
  }
}

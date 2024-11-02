package practice.structural.flyweight;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class AlchemistShop {

  private final List<MagicPotion> summitShelf;
  private final List<MagicPotion> middleShelf;
  private final List<MagicPotion> bottomShelf;

  public AlchemistShop() {
    final var brewer = new PotionBrewer();
    summitShelf = List.of(
        brewer.brewPotion(PotionType.STRENGTH),
        brewer.brewPotion(PotionType.IMMUNITY),
        brewer.brewPotion(PotionType.STRENGTH)
    );
    middleShelf = List.of(
        brewer.brewPotion(PotionType.IMMUNITY),
        brewer.brewPotion(PotionType.AGILITY),
        brewer.brewPotion(PotionType.AGILITY),
        brewer.brewPotion(PotionType.IMMUNITY)
    );
    bottomShelf = List.of(
        brewer.brewPotion(PotionType.HEALING),
        brewer.brewPotion(PotionType.AGILITY),
        brewer.brewPotion(PotionType.HEALING)
    );
  }

  public void drinkAllPotions() {
    log.info("Taking `SUMMIT` Shelf...");
    summitShelf.forEach(MagicPotion::drink);
    log.info("Taking `MIDDLE` Shelf...");
    middleShelf.forEach(MagicPotion::drink);
    log.info("Taking `BOTTOM` Shelf...");
    bottomShelf.forEach(MagicPotion::drink);
  }
}

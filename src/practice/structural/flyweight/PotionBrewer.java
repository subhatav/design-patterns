package practice.structural.flyweight;

import java.util.EnumMap;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public final class PotionBrewer {

  private final Map<PotionType, MagicPotion> potionsJar;

  public PotionBrewer() {
    potionsJar = new EnumMap<>(PotionType.class);
  }

  public MagicPotion brewPotion(@NonNull final PotionType potionType) {
    return potionsJar.computeIfAbsent(potionType, type -> type.getCreator().get());
  }
}

package practice.structural.flyweight;

import java.util.function.Supplier;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PotionType {

  IMMUNITY(ImmunityPotion::new),
  STRENGTH(StrengthPotion::new),
  AGILITY(AgilityPotion::new),
  HEALING(HealingPotion::new);

  @NonNull
  private final Supplier<MagicPotion> creator;
}

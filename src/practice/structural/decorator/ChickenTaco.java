package practice.structural.decorator;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class ChickenTaco extends TacoDecorator {

  private static final Float MULTIPLIER = 1.35F;

  public ChickenTaco(@NonNull final TacoRecipe taco) {
    super(taco);
  }

  @Override
  public float getCost() {
    return taco.getCost() * MULTIPLIER;
  }
}

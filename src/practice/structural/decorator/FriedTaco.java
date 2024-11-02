package practice.structural.decorator;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class FriedTaco extends TacoDecorator {

  private static final Float MULTIPLIER = 1.15F;

  public FriedTaco(@NonNull final TacoRecipe taco) {
    super(taco);
  }

  @Override
  public float getCost() {
    return taco.getCost() * MULTIPLIER;
  }
}

package practice.behavioral.visitor;

import java.util.Arrays;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
public abstract sealed class ArmyUnit permits Captain, Recruit, Sergeant {

  private final ArmyUnit[] children;

  protected ArmyUnit(@NonNull final ArmyUnit... children) {
    this.children = children;
  }

  public void accept(@NonNull final ArmyVisitor visitor) {
    Arrays.stream(children).forEach(child -> child.accept(visitor));
  }
}

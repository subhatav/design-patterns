package practice.behavioral.visitor;

import lombok.NonNull;
import lombok.ToString;

@ToString
public final class Captain extends ArmyUnit {

  public Captain(@NonNull final ArmyUnit... children) {
    super(children);
  }

  @Override
  public void accept(@NonNull final ArmyVisitor visitor) {
    visitor.meetSoldier(this);
    super.accept(visitor);
  }
}

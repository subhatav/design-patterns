package practice.behavioral.mediator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public final class Bandit extends PartyMember {

  @Override
  public String memberName() {
    return getClass().getSimpleName();
  }
}

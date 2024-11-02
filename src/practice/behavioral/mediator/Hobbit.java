package practice.behavioral.mediator;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
public final class Hobbit extends PartyMember {

  @Override
  public String memberName() {
    return getClass().getSimpleName();
  }
}
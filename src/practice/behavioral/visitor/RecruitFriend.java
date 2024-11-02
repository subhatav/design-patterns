package practice.behavioral.visitor;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class RecruitFriend implements ArmyVisitor {

  @Override
  public void meetSoldier(@NonNull final Recruit soldier) {
    log.info("Visitor <" + this + "> GREETS => [" + soldier + "]");
  }

  @Override
  public void meetSoldier(@NonNull final Sergeant soldier) {
    log.info("Visitor <" + this + "> SALUTES => [" + soldier + "]");
  }

  @Override
  public void meetSoldier(@NonNull final Captain soldier) {
    log.info("Visitor <" + this + "> SALUTES => [" + soldier + "]");
  }
}

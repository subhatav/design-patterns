package practice.behavioral.visitor;

import lombok.NonNull;

public sealed interface ArmyVisitor permits CaptainFriend, RecruitFriend, SergeantFriend {

  void meetSoldier(@NonNull final Recruit soldier);

  void meetSoldier(@NonNull final Sergeant soldier);

  void meetSoldier(@NonNull final Captain soldier);
}

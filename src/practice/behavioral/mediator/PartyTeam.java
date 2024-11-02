package practice.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class PartyTeam implements Party {

  private final List<Member> members = new ArrayList<>();

  @Override
  public void includeMember(@NonNull final Member personnel) {
    members.add(personnel); // Register PERSONNEL as Member of Party
    personnel.joinParty(this); // Give out Personnel MEMBERSHIP Card
  }

  @Override
  public void act(@NonNull final Member actor, @NonNull final PartyAction action) {
    members.stream().filter(member -> !member.equals(actor)) // Find out REACTORS
        .forEach(reactor -> reactor.partyAction(action)); // Do REACTION of Party
  }
}

package practice.behavioral.mediator;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public abstract sealed class PartyMember implements Member permits Hobbit, Bandit, Wizard {

  protected Party currentParty;

  public abstract String memberName();

  @Override
  public void joinParty(Party party) {
    currentParty = party; // Receives the MEMBERSHIP Card of PARTY as its Member
    log.info("PARTY with <" + memberName() + "> Member => [" + party + "]");
  }

  @Override
  public void partyAction(PartyAction action) {
    log.info("REACTION of <" + memberName() + "> Member => " + action.getReaction());
  }

  @Override
  public void performAction(PartyAction action) {
    if (currentParty != null) {
      log.info("ACTION from <" + memberName() + "> Member => " + action.getAction());
      currentParty.act(this, action); // Invokes the REACTION of other PARTY Members
    }
  }
}

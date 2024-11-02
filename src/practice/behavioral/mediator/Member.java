package practice.behavioral.mediator;

import lombok.NonNull;

public sealed interface Member permits PartyMember {

  void joinParty(@NonNull final Party party);

  void partyAction(@NonNull final PartyAction action);

  void performAction(@NonNull final PartyAction action);
}

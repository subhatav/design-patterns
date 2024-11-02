package practice.behavioral.mediator;

import lombok.NonNull;

public sealed interface Party permits PartyTeam {

  void includeMember(@NonNull final Member personnel);

  void act(@NonNull final Member actor, @NonNull final PartyAction action);
}

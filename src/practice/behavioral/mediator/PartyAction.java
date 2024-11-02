package practice.behavioral.mediator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum PartyAction {

  LOOT("LOOTS for Gold", "TAKES share of Gold"),
  COOK("COOKS for Team", "TAKES share of Food"),
  KILL("KILLS Hostiles", "CHEERS in total Joy");

  @NonNull
  private final String action;
  @NonNull
  private final String reaction;
}

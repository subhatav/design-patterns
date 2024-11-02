package practice.behavioral.chain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum WorkType {

  COLLECT_TAX(1),
  INTERROGATE(2),
  PLAN_BATTLE(3),
  SLAY_DRAGON(4);

  @NonNull
  private final int level;
}

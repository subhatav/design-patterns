package practice.behavioral.iterator;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum ItemType {

  ANTIC(1),
  SWORD(2),
  ARMOR(3),
  CROWN(4);

  @NonNull
  private final int tier;
}

package practice.behavioral.memento;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum StarType {

  SUN("sun"),
  RED_GIANT("red-giant"),
  WHITE_DWARF("white-dwarf"),
  SUPERNOVA("supernova"),
  DEAD("dead-star");

  @NonNull
  private final String title;
}

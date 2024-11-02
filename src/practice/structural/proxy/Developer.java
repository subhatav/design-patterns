package practice.structural.proxy;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Developer {

  @NonNull
  private final Type type;

  @NoArgsConstructor
  protected enum Type {

    INTERVIEWER, INTERVIEWEE
  }
}

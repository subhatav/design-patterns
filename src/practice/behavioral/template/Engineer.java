package practice.behavioral.template;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@Setter
@ToString
@EqualsAndHashCode
public final class Engineer {

  @NonNull
  private HackStyle hackStyle;

  public void rip() {
    hackStyle.hack();
  }
}

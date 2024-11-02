package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StaticBlock {

  private static final StaticBlock INSTANCE;

  static {
    INSTANCE = new StaticBlock(); // Initialized EAGERLY
  }

  public static StaticBlock getInstance() {
    return INSTANCE;
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

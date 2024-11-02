package practice.creational.singleton;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BillPughHolder {

  @UtilityClass
  private static final class InstanceHolder {

    private static final BillPughHolder INSTANCE = new BillPughHolder();
  }

  public static BillPughHolder getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

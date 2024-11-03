package practice.behavioral.state;

import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@Setter
@ToString
@EqualsAndHashCode
public final class VendorMachine {

  private VendorState state = new NoCoinState();

  public void insertMoney() {
    log.info("ATTEMPT to INSERT Money => [" + this + "]");
    state.insertCoin(this); // Attempt to INSERT Money
  }

  public void ejectMoney() {
    log.info("ATTEMPT to EJECT Money => [" + this + "]");
    state.ejectCoin(this); // Attempt to EJECT Money
  }

  public void dispenseFood() {
    log.info("ATTEMPT to DISPENSE Food => [" + this + "]");
    state.dispenseFood(this); // Try to DISPENSE Food
  }
}

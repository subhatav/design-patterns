package practice.behavioral.state;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class HasCoinState implements VendorState {

  @Override
  public void insertCoin(@NonNull final VendorMachine machine) {
    log.warning("FAILED in INSERTING Coin => [" + machine + "]");
  }

  @Override
  public void ejectCoin(@NonNull final VendorMachine machine) {
    machine.setState(new NoCoinState()); // ALTER state afterwards
    log.info("PASSED in EJECTING Coin => [" + machine + "]");
  }

  @Override
  public void dispenseFood(@NonNull final VendorMachine machine) {
    machine.setState(new NoCoinState()); // ALTER state after action
    log.info("PASSED in DISPENSING Food => [" + machine + "]");
  }
}

package practice.behavioral.state;

import lombok.NonNull;

public sealed interface VendorState permits HasCoinState, NoCoinState {

  void insertCoin(@NonNull final VendorMachine machine);

  void ejectCoin(@NonNull final VendorMachine machine);

  void dispenseFood(@NonNull final VendorMachine machine);
}

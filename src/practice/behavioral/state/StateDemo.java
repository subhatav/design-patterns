package practice.behavioral.state;

/**
 * Example of State Design Pattern
 */
public final class StateDemo {

  public static void main(final String... arguments) {

    final var machine = new VendorMachine();

    machine.insertMoney(); // Money is INSERTED
    machine.dispenseFood(); // Food is DISPENSED

    machine.insertMoney(); // Money is INSERTED
    machine.insertMoney(); // Coin is NOT Inserted
    machine.ejectMoney(); // Money is EJECTED

    machine.dispenseFood(); // Food is NOT Dispensed

    machine.insertMoney(); // Money is INSERTED
    machine.dispenseFood(); // Food is DISPENSED

    machine.ejectMoney(); // Money is NOT Ejected
  }
}

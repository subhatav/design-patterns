package course.week1.ungraded.adapter;

public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {

  private final OldCoffeeMachine adaptedMachine;

  public CoffeeTouchscreenAdapter(final OldCoffeeMachine vendingMachine) {

    adaptedMachine = vendingMachine;
  }

  @Override
  public void chooseFirstSelection() {

    adaptedMachine.pressFirstButton();
  }

  @Override
  public void chooseSecondSelection() {

    adaptedMachine.pressSecondButton();
  }
}
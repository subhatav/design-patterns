package practice.behavioral.command;

/**
 * Example of Command Design Pattern
 */
public final class CommandDemo {

  public static void main(final String... arguments) {

    final var gardenTask = new SwitchTask(new SwitchButton("Garden"));
    final var toiletTask = new SwitchTask(new SwitchButton("Toilet"));
    final var kitchenTask = new SwitchTask(new SwitchButton("Kitchen"));
    final var bedroomTask = new SwitchTask(new SwitchButton("Bedroom"));

    final var remoteControl = new RemoteControl(); // Invoker of Switch Tasks

    remoteControl.pressButton(gardenTask); // Turns ON Switch at the Garden
    remoteControl.pressButton(toiletTask); // Turns ON Switch at the Toilet
    remoteControl.pressButton(kitchenTask); // Turns ON Switch at the Kitchen
    remoteControl.pressButton(bedroomTask); // Turns ON Switch at the Bedroom

    remoteControl.undoAction(); // UNDO Task = Turns OFF Switch at the Bedroom
    remoteControl.undoAction(); // UNDO Task = Turns OFF Switch at the Kitchen

    remoteControl.redoAction(); // REDO Task = Turns ON Switch at the Kitchen
    remoteControl.redoAction(); // REDO Task = Turns ON Switch at the Bedroom
  }
}

package practice.behavioral.command;

import java.util.Deque;
import java.util.LinkedList;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public final class RemoteControl {

  @NonNull
  private final Deque<SwitchTask> undoStack = new LinkedList<>();
  @NonNull
  private final Deque<SwitchTask> redoStack = new LinkedList<>();

  public void pressButton(@NonNull final SwitchTask task) {
    log.info("Performing Task => [" + task + "]");
    task.execute(); // Toggle from CURRENT State
    undoStack.offerLast(task);
  }

  public void undoAction() {
    if (undoStack.isEmpty()) {
      log.warning("No Action is available to UNDO!");
      return;
    }
    var lastAction = undoStack.pollLast();
    redoStack.offerLast(lastAction);
    log.info("UNDO of Action => [" + lastAction + "]");
    lastAction.execute(); // Toggle to LAST State
  }

  public void redoAction() {
    if (redoStack.isEmpty()) {
      log.warning("No Action is available to REDO!");
      return;
    }
    var lastAction = redoStack.pollLast();
    undoStack.offerLast(lastAction);
    log.info("REDO of Action => [" + lastAction + "]");
    lastAction.execute(); // Toggle to LAST State
  }
}

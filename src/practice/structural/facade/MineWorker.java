package practice.structural.facade;

import java.util.Arrays;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
public abstract sealed class MineWorker permits CartOperator, TunnelDigger {

  public enum ActionType {

    SLEEP, WAKE_UP, GO_HOME, GO_TO_MINE, WORK_IN_MINE
  }

  public abstract String name();

  public void sleep() {
    log.info("Worker <" + this.name() + "> goes to SLEEP...");
  }

  public void wakeUp() {
    log.info("Worker <" + this.name() + "> has WOKE up...");
  }

  public void goToMine() {
    log.info("Worker <" + this.name() + "> goes to MINE...");
  }

  public void goHome() {
    log.info("Worker <" + this.name() + "> goes back HOME...");
  }

  public abstract void workInMine();

  public void perform(@NonNull final ActionType... actions) {
    Arrays.stream(actions).forEach(this::perform); // Series
  }

  private void perform(@NonNull final ActionType action) {
    switch (action) {
      case SLEEP -> sleep();
      case WAKE_UP -> wakeUp();
      case GO_TO_MINE -> goToMine();
      case GO_HOME -> goHome();
      case WORK_IN_MINE -> workInMine();
    }
  }
}

package practice.structural.facade;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;
import practice.structural.facade.MineWorker.ActionType;

@Log
@ToString
@EqualsAndHashCode
public final class MineFacade {

  private final List<MineWorker> mineWorkers;

  public MineFacade() {
    this.mineWorkers = List.of(new CartOperator(), new TunnelDigger());
  }

  public void startDay() {
    scheduleActions(mineWorkers, ActionType.WAKE_UP, ActionType.GO_TO_MINE);
  }

  public void digOutGold() {
    scheduleActions(mineWorkers, ActionType.WORK_IN_MINE);
  }

  public void endDay() {
    scheduleActions(mineWorkers, ActionType.GO_HOME, ActionType.SLEEP);
  }

  private static void scheduleActions(
      @NonNull final Collection<MineWorker> workers,
      @NonNull final ActionType... actions // Series
  ) {
    log.info("PERFORMING Actions => " + Arrays.toString(actions));
    workers.forEach(worker -> worker.perform(actions)); // Orchestrate
  }
}

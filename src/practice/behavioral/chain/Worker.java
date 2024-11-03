package practice.behavioral.chain;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Setter
@EqualsAndHashCode
public abstract sealed class Worker permits General, Jailer, King, Officer {

  protected Worker next; // Worker who is NEXT in CHAIN of Responsibility

  protected abstract boolean canHandle(final @NonNull WorkType workType);

  public void perform(@NonNull final Work work) {
    if (canHandle(work.getWorkType())) {
      var name = getClass().getSimpleName(); // Fetch Worker NAME
      var order = work.getDescription(); // Get ORDER Description
      log.info("Worker for <" + order + "> Job => " + name);
    } else {
      next.perform(work); // DELEGATE to Worker next up in CHAIN
    }
  }
}

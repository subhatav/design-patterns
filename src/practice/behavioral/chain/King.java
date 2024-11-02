package practice.behavioral.chain;

import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
public final class King extends Worker {

  @Override
  protected boolean canHandle(final @NonNull WorkType workType) {
    return true; // LAST Worker should be ABLE to handle ANY Tier
  }

  @Override
  public void perform(@NonNull final Work work) {
    var name = getClass().getSimpleName(); // Fetch Worker NAME
    var order = work.getDescription(); // Get ORDER Description
    log.info("Worker for <" + order + "> Job => " + name);
  }
}

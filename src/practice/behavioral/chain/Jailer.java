package practice.behavioral.chain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public final class Jailer extends Worker {

  private static final int MAX_PRIORITY = 2;

  @NonNull
  private final int capability; // Handling Limit

  public Jailer() {
    this(MAX_PRIORITY);
  }

  @Override
  protected boolean canHandle(final @NonNull WorkType workType) {
    return workType.getLevel() <= capability; // Check Work TIER
  }
}

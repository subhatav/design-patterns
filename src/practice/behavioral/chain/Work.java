package practice.behavioral.chain;

import lombok.Data;
import lombok.NonNull;

@Data
public final class Work {

  @NonNull
  private final WorkType workType;
  @NonNull
  private final String description;
}
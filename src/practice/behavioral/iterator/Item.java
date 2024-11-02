package practice.behavioral.iterator;

import lombok.Data;
import lombok.NonNull;

@Data
public final class Item {

  @NonNull
  private final ItemType itemType;
  @NonNull
  private final String description;
}

package practice.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Attic {

  @NonNull
  private final List<Item> items;

  public void takeItems(@NonNull final ItemType itemType) {
    final var robber = new Robber(itemType, new ArrayList<>(items));
    log.info("Searching for Item Type => [" + itemType + "]");
    // log.info("ALL Items => " + getItems()); // Print ALL Items
    while (robber.hasNextItem()) {
      log.info("Item in Attic => [" + robber.nextItem() + "]");
    }
  }
}

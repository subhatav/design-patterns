package practice.behavioral.iterator;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class Robber implements Iterator<Item> {

  @NonNull
  private final ItemType itemType;
  @NonNull
  private final List<Item> items;

  private int currentIndex = -1;

  @Override
  public boolean hasNextItem() {
    return findNextIndex() != -1;
  }

  @Override
  public Item nextItem() {
    currentIndex = findNextIndex();
    if (currentIndex != -1) {
      return items.get(currentIndex);
    }
    return null; // Send back NO Item
  }

  private int findNextIndex() {
    var nextIndex = currentIndex;
    while (true) {
      nextIndex += 1;
      if (nextIndex >= items.size()) {
        return -1; // Attic is EMPTY
      }
      if (itemType.equals(ItemType.ANTIC)) {
        return nextIndex; // ANTIC => ANY Item
      }
      final var nextItem = items.get(nextIndex);
      if (itemType.equals(nextItem.getItemType())) {
        return nextIndex; // Find out CORRECT Item
      }
    }
  }
}

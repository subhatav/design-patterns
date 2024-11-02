package practice.behavioral.iterator;

import java.util.stream.IntStream;
import lombok.NonNull;

/**
 * Example of Iterator Design Pattern
 */
public final class IteratorDemo {

  public static void main(final String... arguments) {

    makeAtticWithItems(5).takeItems(ItemType.ANTIC);
    makeAtticWithItems(10).takeItems(ItemType.SWORD);
    makeAtticWithItems(15).takeItems(ItemType.ARMOR);
    makeAtticWithItems(10).takeItems(ItemType.CROWN);
  }

  private static Attic makeAtticWithItems(@NonNull final int nbItems) {
    return new Attic(IntStream.range(1, nbItems).mapToObj(itemId -> {
      if (itemId % 2 == 0) {
        return new Item(ItemType.SWORD, "Sword-" + itemId);
      } else if (itemId % 3 == 0) {
        return new Item(ItemType.ARMOR, "Armor-" + itemId);
      } else if (itemId % 7 == 0) {
        return new Item(ItemType.CROWN, "Crown-" + itemId);
      } else {
        return new Item(ItemType.ANTIC, "Antic-" + itemId);
      }
    }).toList()); // Construct ATTIC with given NUMBER of ITEMS in it
  }
}

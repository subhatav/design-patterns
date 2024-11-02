package practice.behavioral.iterator;

public sealed interface Iterator<T> permits Robber {

  boolean hasNextItem(); // Check availability

  T nextItem(); // Get NEXT Item by some logic
}

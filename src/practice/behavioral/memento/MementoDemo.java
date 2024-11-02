package practice.behavioral.memento;

import java.util.ArrayDeque;

/**
 * Example of Memento Design Pattern
 */
public final class MementoDemo {

  public static void main(final String[] arguments) {

    final var starStates = new ArrayDeque<StarState>();
    final var starManager = makeRandomStar(); // BIRTH

    starStates.push(starManager.getState());
    starManager.passTime(); // ADVANCES time

    starStates.push(starManager.getState());
    starManager.passTime(); // ADVANCES time

    starStates.push(starManager.getState());
    starManager.passTime(); // ADVANCES time

    starStates.push(starManager.getState());
    starManager.passTime(); // ADVANCES time

    starManager.printState(); // Star is DEAD

    while (!starStates.isEmpty()) { // REWIND
      starManager.setState(starStates.poll());
    }
  }

  private static StarManager makeRandomStar() {
    return new StarManager(StarType.SUN, 10000000, 500000);
  }
}

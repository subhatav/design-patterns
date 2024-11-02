package practice.behavioral.chain;


import java.util.Arrays;
import java.util.List;

/**
 * Example of Chain of Responsibility Design Pattern
 */
public final class ChainDemo {

  public static void main(final String... arguments) {

    getWorkList().forEach(makeWorkerChain()::perform);
  }

  private static Worker makeWorkerChain() {

    final var general = new General();
    general.setNext(new King());

    final var jailer = new Jailer();
    jailer.setNext(general);

    final var officer = new Officer();
    officer.setNext(jailer);

    return officer;
  }

  private static List<Work> getWorkList() {
    return Arrays.asList(
        new Work(WorkType.INTERROGATE, "interrogation"),
        new Work(WorkType.COLLECT_TAX, "tax-collection"),
        new Work(WorkType.SLAY_DRAGON, "dragon-slaying"),
        new Work(WorkType.PLAN_BATTLE, "castle-defense")
    );
  }
}

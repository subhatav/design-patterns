package practice.behavioral.template;

/**
 * Example of Template Method Design Pattern
 */
public final class TemplateDemo {

  public static void main(final String[] arguments) {

    final var hacker = new Engineer();

    hacker.setHackStyle(new BruteHack());
    hacker.rip(); // RIP Public Website

    hacker.setHackStyle(new SubtleHack());
    hacker.rip(); // RIP Private Website
  }
}

package practice.behavioral.mediator;

/**
 * Example of Mediator Design Pattern
 */
public final class MediatorDemo {

  public static void main(final String[] arguments) {

    final var fellowship = new PartyTeam();

    final var bandit = new Bandit();
    final var hobbit = new Hobbit();
    final var wizard = new Wizard();

    fellowship.includeMember(wizard);
    fellowship.includeMember(hobbit);
    fellowship.includeMember(bandit);

    hobbit.performAction(PartyAction.COOK);
    wizard.performAction(PartyAction.KILL);
    bandit.performAction(PartyAction.LOOT);
  }
}

package practice.behavioral.visitor;

/**
 * Example of Visitor Design Pattern
 */
public final class VisitorDemo {

  public static void main(final String[] arguments) {

    final var soldier = new Captain(
        new Sergeant(new Recruit(), new Recruit()),
        new Sergeant(new Recruit(), new Recruit())
    ); // Create Army CAMP hierarchy of Soldiers

    soldier.accept(new RecruitFriend());
    soldier.accept(new SergeantFriend());
    soldier.accept(new CaptainFriend());
  }
}

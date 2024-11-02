package practice.structural.composite;

/**
 * Example of Composite Design Pattern
 */
public final class CompositeDemo {

  public static void main(final String... arguments) {

    final var headDepartment1 = new HeadDepartment("HR");
    final var headDepartment2 = new HeadDepartment("IT");

    final var headDepartment3 = new HeadDepartment("Company");

    headDepartment1.addDepartment(new LeafDepartment("Relations"));
    headDepartment1.addDepartment(new LeafDepartment("Accounts"));

    headDepartment2.addDepartment(new LeafDepartment("Research"));
    headDepartment2.addDepartment(new LeafDepartment("Testing"));

    headDepartment3.addDepartments(headDepartment1, headDepartment2);

    headDepartment3.printDepartmentName(); // Prints TOTAL Hierarchy
  }
}

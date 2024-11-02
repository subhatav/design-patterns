package practice.structural.composite;

public sealed interface Department permits HeadDepartment, LeafDepartment {

  void printDepartmentName(); // PRINTS name of VARIOUS types of Department
}

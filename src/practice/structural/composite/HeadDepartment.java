package practice.structural.composite;

import java.util.ArrayList;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class HeadDepartment implements Department {

  @ToString.Exclude
  private final List<Department> departments = new ArrayList<>();

  @NonNull
  private final String name;

  public void addDepartment(Department department) {
    departments.add(department);
  }

  public void addDepartments(Department... departments) {
    this.departments.addAll(List.of(departments));
  }

  public void removeDepartment(Department department) {
    departments.remove(department);
  }

  @Override
  public void printDepartmentName() {
    log.info("NAME of Department => [" + this + "]");
    departments.forEach(Department::printDepartmentName);
  }
}

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

  public void addDepartment(@NonNull final Department department) {
    departments.add(department); // ADD any SINGLE element in list
  }

  public void addDepartments(@NonNull final Department... departments) {
    this.departments.addAll(List.of(departments)); // ADD multiple items
  }

  public void removeDepartment(@NonNull final Department department) {
    departments.remove(department); // REMOVE any particular element
  }

  @Override
  public void printDepartmentName() {
    log.info("NAME of Department => [" + this + "]");
    departments.forEach(Department::printDepartmentName);
  }
}

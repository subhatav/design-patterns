package practice.structural.composite;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class LeafDepartment implements Department {

  @NonNull
  private final String name;

  @Override
  public void printDepartmentName() {
    log.info("NAME of Department => [" + this + "]");
  }
}

package practice.creational.pool;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class PersonPool extends ObjectPool<Candidate> {

  @Override
  protected Candidate create() {
    return new Candidate();
  }
}

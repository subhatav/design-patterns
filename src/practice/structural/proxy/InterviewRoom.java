package practice.structural.proxy;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@EqualsAndHashCode
@ToString(callSuper = true)
public final class InterviewRoom implements CompanyRoom {

  @Override
  public void use(@NonNull final Developer developer) {
    log.info("Person <" + developer + "> is USING Room [" + this + "]");
  }
}

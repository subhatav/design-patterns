package practice.creational.singleton;

import lombok.extern.java.Log;

@Log
public enum EnumSingleton {

  INSTANCE;

  @Override
  public String toString() {
    return getDeclaringClass().getCanonicalName() + "@" + hashCode();
  }

  public void printInstanceDetails() {
    log.info("Object => [" + this + "]");
  }
}

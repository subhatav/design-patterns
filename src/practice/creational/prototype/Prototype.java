package practice.creational.prototype;

import lombok.SneakyThrows;

public abstract sealed class Prototype<T> implements Cloneable permits Weapon {

  @SneakyThrows
  @SuppressWarnings("unchecked")
  public T copy() {
    return (T) super.clone(); // Does SHALLOW copy using `Object.clone()` method
  }
}

package practice.creational.pool;

/**
 * Example of Object Pool Design Pattern
 */
public final class PoolDemo {

  public static void main(final String[] arguments) {

    final var objectPool = new PersonPool();
    objectPool.status(); // INITIAL status

    final var personObj1 = objectPool.borrow();
    personObj1.print(); // FIRST instance

    objectPool.status(); // CURRENT status

    final var personObj2 = objectPool.borrow();
    personObj2.print(); // SECOND instance

    objectPool.status(); // CURRENT status

    objectPool.remit(personObj1); // REMIT
    objectPool.status(); // CURRENT status

    objectPool.remit(personObj2); // REMIT
    objectPool.status(); // CURRENT status

    final var personObj3 = objectPool.borrow();
    personObj3.print(); // Not THIRD instance

    objectPool.status(); // CURRENT status

    objectPool.remit(personObj3); // REMIT
    objectPool.status(); // CURRENT status
  }
}

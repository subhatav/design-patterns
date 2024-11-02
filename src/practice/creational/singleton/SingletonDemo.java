package practice.creational.singleton;

/**
 * Example of Singleton Design Pattern
 */
public final class SingletonDemo {

  public static void main(final String... arguments) {

    EagerLoaded.getInstance().printInstanceDetails();
    EagerLoaded.getInstance().printInstanceDetails();

    StaticBlock.getInstance().printInstanceDetails();
    StaticBlock.getInstance().printInstanceDetails();

    LazyLoaded.getInstance().printInstanceDetails();
    LazyLoaded.getInstance().printInstanceDetails();

    ThreadSafeLazy.getInstance().printInstanceDetails();
    ThreadSafeLazy.getInstance().printInstanceDetails();

    DoubleCheckLock.getInstance().printInstanceDetails();
    DoubleCheckLock.getInstance().printInstanceDetails();

    BillPughHolder.getInstance().printInstanceDetails();
    BillPughHolder.getInstance().printInstanceDetails();

    EnumSingleton.INSTANCE.printInstanceDetails();
    EnumSingleton.INSTANCE.printInstanceDetails();
  }
}

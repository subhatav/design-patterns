package practice.behavioral.observer;

/**
 * Example of Observer Design Pattern
 */
public final class ObserverDemo {

  public static void main(final String... arguments) {

    final var weather = new Weather();

    final var orcBand = new OrcBand();
    final var trollBand = new TrollBand();

    weather.attach(orcBand);
    weather.attach(trollBand);

    weather.advanceTime();
    weather.advanceTime();
    weather.advanceTime();
    weather.advanceTime();
    weather.advanceTime();

    weather.detach(orcBand);
    weather.detach(trollBand);
  }
}

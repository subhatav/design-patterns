package practice.behavioral.observer;

import lombok.NonNull;

public sealed interface Observer permits OrcBand, TrollBand {

  void update(@NonNull final WeatherType weatherType);
}

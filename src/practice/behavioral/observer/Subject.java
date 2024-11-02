package practice.behavioral.observer;

import lombok.NonNull;

public sealed interface Subject permits Weather {

  void attach(@NonNull final Observer watcher);

  void detach(@NonNull final Observer watcher);

  void notifyObservers();
}

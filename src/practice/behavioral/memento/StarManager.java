package practice.behavioral.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public final class StarManager {

  @NonNull
  private StarType type;
  @NonNull
  private int ageYears;
  @NonNull
  private int massTons;

  public void passTime() {
    ageYears *= 2;
    massTons *= 8;
    switch (type) {
      case SUN -> type = StarType.RED_GIANT;
      case RED_GIANT -> type = StarType.WHITE_DWARF;
      case WHITE_DWARF -> type = StarType.SUPERNOVA;
      case SUPERNOVA -> type = StarType.DEAD;
      case DEAD -> {
        ageYears *= 2;
        massTons = 0;
      }
    }
  }

  public void printState() {
    log.info("LAST Star STATE => [" + this + "]");
  }

  StarState getState() {
    log.info("CURRENT Star STATE => [" + this + "]");
    final var memento = new StarMemento();
    memento.setAgeYears(ageYears);
    memento.setMassTons(massTons);
    memento.setType(type);
    return memento;
  }

  void setState(@NonNull final StarState state) {
    final var memento = (StarMemento) state;
    this.type = memento.getType();
    this.ageYears = memento.getAgeYears();
    this.massTons = memento.getMassTons();
    log.info("REVIVED Star STATE => [" + this + "]");
  }

  @Data
  static final class StarMemento implements StarState {

    private StarType type;
    private int ageYears;
    private int massTons;
  }
}

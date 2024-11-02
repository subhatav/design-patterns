package practice.structural.proxy;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public final class RoomProxy implements CompanyRoom {

  private static final int NB_OCCUPANTS = 2;

  @NonNull
  private final CompanyRoom companyRoom;

  private int nbCurrentOccupants = 0;

  @Override
  public void use(@NonNull final Developer developer) {
    if (nbCurrentOccupants < NB_OCCUPANTS) {
      nbCurrentOccupants += 1;
      companyRoom.use(developer);
    } else {
      log.warning("Person <" + developer + "> cannot USE Room [" + companyRoom + "]");
    }
  }
}

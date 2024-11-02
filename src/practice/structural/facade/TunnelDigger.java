package practice.structural.facade;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.java.Log;

@Log
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public final class TunnelDigger extends MineWorker {

  @Override
  public String name() {
    return getClass().getSimpleName();
  }

  @Override
  public void workInMine() {
    log.info("Worker <" + name() + "> DIGS Tunnel...");
  }
}

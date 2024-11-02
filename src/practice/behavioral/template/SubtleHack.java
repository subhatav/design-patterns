package practice.behavioral.template;

import lombok.NonNull;
import lombok.extern.java.Log;

@Log
public final class SubtleHack extends HackStyle {

  @Override
  protected String chooseTarget() {
    return "private-website";
  }

  @Override
  protected void confuseTarget(@NonNull final String targetName) {
    log.info("CONFUSED Target using <" + getStyleName() + "> Style => [" + targetName + "]");
  }

  @Override
  protected void stealResource(@NonNull final String targetName) {
    log.info("STOLE Resource using <" + getStyleName() + "> Style => [" + targetName + "]");
  }

  private String getStyleName() {
    return getClass().getSimpleName();
  }
}

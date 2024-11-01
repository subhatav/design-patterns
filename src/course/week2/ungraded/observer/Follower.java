package course.week2.ungraded.observer;

public class Follower implements Observer {

  private String followerName;

  public Follower(final String followerName) {

    this.followerName = followerName;
  }

  public String getFollowerName() {

    return followerName;
  }

  public void setFollowerName(final String followerName) {

    this.followerName = followerName;
  }

  @Override
  public void update(final String status) {

    // Logic to give updates to the Followers
  }

  public void play() {

    // Logic to play the Channel livestream
  }
}

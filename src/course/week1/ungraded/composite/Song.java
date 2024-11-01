package course.week1.ungraded.composite;

public class Song implements IComponent {

  private final String name;
  private final String artist;

  private float speed = 1f;

  public Song(final String name, final String artist) {

    this.name = name;
    this.artist = artist;
  }

  @Override
  public void setSpeed(final float speed) {

    this.speed = speed;
  }

  @Override
  public void play() {

    System.out.printf("Playing `%s` by `%s`, at %.2fx Speed...%n", name, artist, speed);
  }

  @Override
  public String getName() {

    return name;
  }

  public String getArtist() {

    return artist;
  }
}

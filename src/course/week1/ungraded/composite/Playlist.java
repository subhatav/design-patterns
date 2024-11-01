package course.week1.ungraded.composite;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IComponent {

  private final String name;

  private final List<IComponent> songs = new ArrayList<>();

  public Playlist(final String name) {

    this.name = name;
  }

  @Override
  public void setSpeed(final float speed) {

    for (final IComponent song : songs) {

      song.setSpeed(speed);
    }
  }

  @Override
  public void play() {

    for (final IComponent song : songs) {

      song.play();
    }
  }

  @Override
  public String getName() {

    return name;
  }

  public void insert(final IComponent song) {

    songs.add(song);
  }

  public void delete(final IComponent song) {

    songs.remove(song);
  }
}

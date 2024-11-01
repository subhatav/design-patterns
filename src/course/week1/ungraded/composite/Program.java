package course.week1.ungraded.composite;

public class Program {

  public static void main(String[] args) {

    final Playlist studyPlaylist = new Playlist("Study");

    final Playlist synthPopPlaylist = new Playlist("Synth Pop");

    final Song synthPopSong1 = new Song("Girl Like You", "Toro Y Moi");
    final Song synthPopSong2 = new Song("Outside", "TOPS");

    synthPopPlaylist.insert(synthPopSong1);
    synthPopPlaylist.insert(synthPopSong2);

    final Playlist experimentalPlaylist = new Playlist("Experimental");

    final Song experimentalSong1 = new Song("About you", "XXYYXX");
    final Song experimentalSong2 = new Song("Motivation", "Clams Casino");
    final Song experimentalSong3 = new Song("Computer Vision", "Oneohtrix Point Never");

    experimentalPlaylist.insert(experimentalSong1);
    experimentalPlaylist.insert(experimentalSong2);
    experimentalPlaylist.insert(experimentalSong3);

    experimentalPlaylist.setSpeed(0.5f);
    experimentalPlaylist.insert(synthPopPlaylist);
    studyPlaylist.insert(experimentalPlaylist);

    final Song glitchSong = new Song("Textuell", "Oval");

    glitchSong.setSpeed(1.25f);
    glitchSong.play();

    System.out.printf("Song Name = [%s].%n", glitchSong.getName());
    System.out.printf("Song Artist = [%s.]%n", glitchSong.getArtist());

    studyPlaylist.insert(glitchSong);
    studyPlaylist.play();

    System.out.printf("Playlist Name = [%s].%n", studyPlaylist.getName());
  }
}

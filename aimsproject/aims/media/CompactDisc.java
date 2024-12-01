package lab002.aimsproject.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter for artist
    public String getArtist() {
        return artist;
    }

    // Methods to manage tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Calculate total length of all tracks
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public String toString() {
        return "CD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getArtist() + ": "
                + getCost() + " $ (" + getLength() + " mins)";
    }

    @Override
    public void play() {
        System.out.println("Playing CD: " + getTitle());
        System.out.println("Artist: " + artist);
        for (Track track : tracks) {
            track.play();
        }
    }
}

package lab002.aimsproject.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters for title and length
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && Objects.equals(title, track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.title);
        System.out.println("Track Length: " + this.length);
    }
}

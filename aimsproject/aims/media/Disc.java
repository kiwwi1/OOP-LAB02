package lab002.aimsproject.aims.media;

public class Disc extends Media {
    private int length;
    private String director;

    // Constructor
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }
    public Disc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost);
        this.length = length;
    }

    public Disc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Disc(String category) {
        super(category);
    }

    // Getters for length and director
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }
}

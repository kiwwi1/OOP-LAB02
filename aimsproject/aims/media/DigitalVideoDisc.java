package lab002.aimsproject.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Constructor
    public DigitalVideoDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost, int length) {
        super(id, title, category, cost, length);
    }
    public DigitalVideoDisc(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public DigitalVideoDisc(String category) {
        super(category);
    }


    // Additional functionality can go here, such as isMatch()
    public boolean isMatch(String title) {
        return getTitle().equalsIgnoreCase(title);
    }
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - "
                + getLength() + " mins: " + getCost() + " $";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length " + this.getLength());
    }
}

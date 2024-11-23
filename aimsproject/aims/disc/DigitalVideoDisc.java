package lab002.aimsproject;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;

    public void setTitle(String title) {
        this.title = title;
    }

    private float cost;
    private static int nbDigitalVideoDiscs = 0;  // Class attribute to count DVDs
    private int id;  // Instance attribute to store unique ID for each DVD

    // Constructor that sets the title and auto-generates id
    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs++;  // Increment the number of DVDs created
        this.id = nbDigitalVideoDiscs;  // Assign a unique id
    }

    // Constructor with title, director, category, and cost
    public DigitalVideoDisc(String title, String director, String category, float cost) {
        this.title = title;
        this.director = director;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Increment the number of DVDs created
        this.id = nbDigitalVideoDiscs;  // Assign a unique id
    }

    // Constructor with title, category, director, length, and cost
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Increment the number of DVDs created
        this.id = nbDigitalVideoDiscs;  // Assign a unique id
    }

    // Constructor with title, category, and cost
    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDiscs++;  // Increment the number of DVDs created
        this.id = nbDigitalVideoDiscs;  // Assign a unique id
    }

    // Getter methods for the attributes
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public int getId() {
        return id;  // Getter for the unique id
    }

    // Static method to get the number of DVDs created
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);  // Case-insensitive comparison
    }

    // toString method for DVD details
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " mins: " + cost + " $";
    }
}


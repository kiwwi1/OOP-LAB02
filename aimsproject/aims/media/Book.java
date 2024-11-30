package lab002.aimsproject.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    // Fields
    private ArrayList<String> authors;

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
        this.authors = new ArrayList<>();
    }
    // Methods to manage authors
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }
}


package lab002.aimsproject.aims.cart;

import lab002.aimsproject.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    // Add a Media item to the cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println("The item has been added: " + media.getTitle());
            } else {
                System.out.println("The item is already in the cart: " + media.getTitle());
            }
        } else {
            System.out.println("The cart is full. Cannot add more items.");
        }
    }

    // Add multiple Media items to the cart
    public void addMedia(Media[] mediaList) {
        for (Media media : mediaList) {
            if (media == null) continue;
            if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
                addMedia(media);
            } else {
                System.out.println("The cart is full. Cannot add more items.");
                break;
            }
        }
    }

    // Remove a Media item from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The item has been removed: " + media.getTitle());
        } else {
            System.out.println("The item is not found in the cart.");
        }
    }

    // Calculate the total cost of the items in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Print the list of ordered items and the total cost
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    // Search for a Media item by ID
    public void searchById(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found item with ID " + id + ": " + media.toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No item found with ID " + id);
        }
    }

    // Search for Media items by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Found item with title \"" + title + "\": " + media.toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No item found with title \"" + title + "\"");
        }
    }

    // Method to get the number of items in the cart
    public String size() {
        return itemsOrdered.size() + " items.";
    }

    // Method to find Media by ID
    public Media findMediaById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                return media;  // Return the media if ID matches
            }
        }
        return null;  // Return null if no media found with the given ID
    }

    // Sort the items in the cart by title
    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media media1, Media media2) {
                return media1.getTitle().compareToIgnoreCase(media2.getTitle());
            }
        });
        System.out.println("The cart has been sorted by title.");
    }

    // Find a Media item by title
    public Media findMediaByTitle(String title) {
        for (Media media : itemsOrdered) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;  // Return the media if title matches
            }
        }
        return null;  // Return null if no media found with the given title
    }

    // Sort the items in the cart by cost
    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media media1, Media media2) {
                return Float.compare(media1.getCost(), media2.getCost());
            }
        });
        System.out.println("The cart has been sorted by cost.");
    }

    // Clear all the items from the cart
    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }
}

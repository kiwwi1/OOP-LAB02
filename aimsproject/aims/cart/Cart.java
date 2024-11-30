package lab002.aimsproject.aims.cart;
import lab002.aimsproject.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // Method to add a single DVD to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc item) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The disc has been added: " + item.getTitle());
        } else {
            System.out.println("The cart is full.");
        }
    }

    // Method to add multiple DVDs (array) to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (dvd == null) continue;
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The disc has been added: " + dvd.getTitle());
            } else {
                System.out.println("The cart is full, cannot add more discs.");
                break;
            }
        }
    }

    // Method to add two DVDs to the cart
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            if (dvd1 != null) {
                itemsOrdered[qtyOrdered] = dvd1;
                qtyOrdered++;
                System.out.println("The disc has been added: " + dvd1.getTitle());
            }
            if (qtyOrdered < MAX_NUMBERS_ORDERED && dvd2 != null) {
                itemsOrdered[qtyOrdered] = dvd2;
                qtyOrdered++;
                System.out.println("The disc has been added: " + dvd2.getTitle());
            }
        } else {
            System.out.println("The cart is full, cannot add more discs.");
        }
    }

    // Method to remove a DVD from the cart
    public void removeDigitalVideoDisc(DigitalVideoDisc item) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == item) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("The disc has been removed: " + item.getTitle());
                return;
            }
        }
        System.out.println("The disc is not found in the cart.");
    }

    // Method to calculate the total cost of the items in the cart
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Method to print the list of ordered items and total cost
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("****************************************************");
    }

    // Method to search DVDs by ID
    public void searchById(int id) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getId() == id) {
                System.out.println("Found DVD with ID " + id + ": " + itemsOrdered[i].toString());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("No DVD found with ID " + id);
        }
    }

    // Method to search DVDs by title
    public void searchByTitle(String title) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("Found DVD with title \"" + title + "\": " + itemsOrdered[i].toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No DVD found with title \"" + title + "\"");
        }
    }

}

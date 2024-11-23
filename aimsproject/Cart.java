package lab002.aimsproject;
import lab002.aimsproject.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc item) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = item;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is full");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc item) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == item) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
            }
        }
        System.out.println("The disc has been removed");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            if (dvd == null) continue;
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                itemsOrdered[qtyOrdered] = dvd;
                qtyOrdered++;
                System.out.println("The disc has been added: " + dvd.getTitle());
            } else {
                System.out.println("The cart is full, cannot add: " + dvd.getTitle());
                break;
            }
        }
    }

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
}


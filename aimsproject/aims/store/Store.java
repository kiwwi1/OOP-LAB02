package lab002.aimsproject.aims.store;

import lab002.aimsproject.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();
    private static final int MAX_ITEMS_IN_STORE = 50; // Maximum capacity of the store

    // Add a media item to the store
    public void addMedia(Media media) {
        if (itemsInStore.size() < MAX_ITEMS_IN_STORE) {
            if (!itemsInStore.contains(media)) {
                itemsInStore.add(media);
                System.out.println("The item \"" + media.getTitle() + "\" has been added to the store.");
            } else {
                System.out.println("The item \"" + media.getTitle() + "\" is already in the store.");
            }
        } else {
            System.out.println("The store is full, cannot add more items.");
        }
    }

    // Remove a media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The item \"" + media.getTitle() + "\" has been removed from the store.");
        } else {
            System.out.println("The item \"" + media.getTitle() + "\" was not found in the store.");
        }
    }

    // Print the details of all media items in the store
    public void printStoreDetails() {
        System.out.println("************** STORE INVENTORY **************");
        if (itemsInStore.isEmpty()) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < itemsInStore.size(); i++) {
                System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
            }
        }
        System.out.println("*********************************************");
    }

    public Media findMediaByTitle(String title) {
        return itemsInStore.stream().filter(media -> media.getTitle().equals(title)).findFirst().orElse(null);
    }
}

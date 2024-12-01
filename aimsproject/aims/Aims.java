package lab002.aimsproject.aims;

import lab002.aimsproject.aims.cart.Cart;
import lab002.aimsproject.aims.media.CompactDisc;
import lab002.aimsproject.aims.media.DigitalVideoDisc;
import lab002.aimsproject.aims.media.Media;
import lab002.aimsproject.aims.store.Store;

import java.util.Scanner;

public class Aims {
    static Scanner scanner = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int choice;
        do {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media’s details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cart.print();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    public static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            switch (choice) {
                case 1:
                    addMediaToCart();
                    break;
                case 2:
                    playMedia();
                    break;
                case 0:
                    storeMenu();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart() {
        System.out.print("Enter media title to add to cart: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart. Current cart size: " + cart.size());
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);

        if (media != null && (media instanceof DigitalVideoDisc || media instanceof CompactDisc)) {
            System.out.println("Playing: " + media.getTitle());
        } else {
            System.out.println("Cannot play this media.");
        }
    }

    public static void updateStore() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    public static void addMediaToStore() {
        System.out.println("Enter media type (DVD, CD, Book): ");
        String mediaType = scanner.nextLine();
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        // Add logic to create the corresponding media object and add it to the store
        // Example: store.addDVD(new DigitalVideoDisc(title));
    }

    public static void removeMediaFromStore() {
        System.out.print("Enter media title to remove: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from store.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void cartMenu() {
        int choice;
        do {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number: 0-1-2-3-4-5: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                case 0:
                    showMenu();
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 0);
    }

    public static void filterMediasInCart() {
        System.out.println("Choose filter option: ");
        System.out.println("1. By ID");
        System.out.println("2. By title");
        int filterChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (filterChoice) {
            case 1:
                filterById();
                break;
            case 2:
                filterByTitle();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void filterById() {
        System.out.print("Enter media ID: ");
        int id = scanner.nextInt();
        Media media = cart.findMediaById(id);
        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void filterByTitle() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void sortMediasInCart() {
        System.out.println("Choose sorting option: ");
        System.out.println("1. By title");
        System.out.println("2. By cost");
        int sortChoice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        switch (sortChoice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.print("Enter media title to remove from cart: ");
        String title = scanner.nextLine();
        Media media = cart.findMediaByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void placeOrder() {
        System.out.println("Order placed. Your cart is now empty.");
        cart.clear();
    }
}

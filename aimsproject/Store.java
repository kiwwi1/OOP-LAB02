package lab002.aimsproject;

public class Store {
    private DigitalVideoDisc[] itemsInStore; // Mảng các DVD có trong cửa hàng
    private int qtyInStore; // Số lượng DVD trong cửa hàng
    private static final int MAX_ITEMS_IN_STORE = 50; // Giới hạn số DVD trong cửa hàng

    // Constructor: Khởi tạo cửa hàng với một số DVD ban đầu (trong trường hợp có)
    public Store() {
        itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
        qtyInStore = 0;
    }

    // Phương thức để thêm DVD vào cửa hàng
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD \"" + dvd.getTitle() + "\" has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    // Phương thức để xóa DVD khỏi cửa hàng
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i].getId() == dvd.getId()) {
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null; // Đặt DVD cuối cùng thành null
                qtyInStore--;
                System.out.println("The DVD \"" + dvd.getTitle() + "\" has been removed from the store.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The DVD \"" + dvd.getTitle() + "\" was not found in the store.");
        }
    }

    // Phương thức để in danh sách DVD trong cửa hàng
    public void printStoreDetails() {
        System.out.println("************** STORE INVENTORY **************");
        if (qtyInStore == 0) {
            System.out.println("The store is empty.");
        } else {
            for (int i = 0; i < qtyInStore; i++) {
                System.out.println((i + 1) + ". " + itemsInStore[i].toString());
            }
        }
        System.out.println("*********************************************");
    }
}

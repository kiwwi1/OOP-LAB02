package lab002.aimsproject;

public class StoreTest {
    public static void main(String[] args) {
        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1", "Action", "Director 1", 120, 25.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2", "Comedy", "Director 2", 90, 20.0f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Movie 3", "Drama", "Director 3", 110, 30.0f);

        // Tạo một cửa hàng mới
        Store store = new Store();

        // Thêm các DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // In ra danh sách DVD trong cửa hàng
        store.printStoreDetails();

        // Xóa DVD khỏi cửa hàng
        store.removeDVD(dvd2);

        // In ra danh sách DVD sau khi xóa
        store.printStoreDetails();

        // Thử xóa một DVD không có trong cửa hàng
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Movie 4", "Action", "Director 4", 105, 28.0f);
        store.removeDVD(dvd4);
    }
}

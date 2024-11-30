package lab002.aimsproject.aims;

import lab002.aimsproject.aims.cart.Cart;
import lab002.aimsproject.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,
                "Animation", "Roger Allers", 87, 19);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2,
                "Science Fiction", "George Lucas", 87, 24);
        anOrder.addDigitalVideoDisc(dvd2);


        // Print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

    }
}

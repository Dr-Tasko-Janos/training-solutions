package attributes.bill;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    List<Item> items = new ArrayList<>();

    public void addItem(String product, int quantity, double price) {
        items.add(new Item(product, quantity, price));
    }

    public List<Item> getItems() {
        return items;
    }

    public double calculateTotalPrice() {
        double sum = 0.0;
        for (Item item : items) {
            sum += item.getPrice() * item.getQuantity();
        }
        return sum;
    }
}

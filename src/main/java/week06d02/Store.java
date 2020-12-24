package week06d02;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private List<Product> products = new ArrayList<>();

    public Store(Product... newProducts) {
        for (Product item : newProducts) {
            this.products.add(item);
        }
    }

    public int getProductByCategoryName(Product.Category category) {
        int result = 0;
        for (Product item : products) {
            if (item.getCategory().equals(category.name())) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);
        System.out.println(store.products.size());
        System.out.println(store.getProductByCategoryName(Product.Category.DAIRY));
    }
}

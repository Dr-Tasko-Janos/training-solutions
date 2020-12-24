package week06d02;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StoreTest {


    @Test
    public void testForFROZEN() {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);

        assertEquals(2, store.getProductByCategoryName(Product.Category.FROZEN));
    }

    @Test
    public void testForDAIRY() {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);

        assertEquals(2, store.getProductByCategoryName(Product.Category.DAIRY));
    }

    @Test
    public void testForBAKEDGOODS() {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);

        assertEquals(1, store.getProductByCategoryName(Product.Category.BAKEDGOODS));
    }

    @Test
    public void testForOTHER() {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);

        assertEquals(1, store.getProductByCategoryName(Product.Category.OTHER));
    }

    @Test
    public void testForOTHERtoGetFalseTestResult() {

        Product product1 = new Product("Pea", Product.Category.FROZEN, 100);
        Product product2 = new Product("Cheese", Product.Category.DAIRY, 50);
        Product product3 = new Product("Milk", Product.Category.DAIRY, 40);
        Product product4 = new Product("Beef", Product.Category.FROZEN, 200);
        Product product5 = new Product("Bread", Product.Category.BAKEDGOODS, 50);
        Product product6 = new Product("Bulb", Product.Category.OTHER, 120);

        Store store = new Store(product1, product2, product3, product4, product5, product6);

        assertEquals(2, store.getProductByCategoryName(Product.Category.OTHER));  //we know that only one OTHER product exists in the list
    }
}

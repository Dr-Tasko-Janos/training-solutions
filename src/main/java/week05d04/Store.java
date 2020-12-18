package week05d04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Store {

    public List<Product> productsList = new ArrayList<>();

    public boolean addProduct(Product product) {
        if (isNotExpiredProduct(product) && itIsNotExist(product)) {
            productsList.add(product);
            return true;
        }
        return false;
    }

    public int getNumberOfExpired() {
        int counter = 0;
        for (Product item : productsList) {
            if (item.getExpiryDate().isBefore(LocalDate.now())) {
                counter++;
            }
        }
        return counter;
    }

    private boolean isNotExpiredProduct(Product product) {
        if (product.getExpiryDate().isBefore(LocalDate.now())) {
            return false;
        }
        return true;
    }

    private boolean itIsNotExist(Product product) {
        for (Product item : productsList) {
            if (product.getName().equals(item.getName())) {
                return false;
            }
        }
        return true;
    }

}


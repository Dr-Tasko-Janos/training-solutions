package week06d02;

public class Product {

    private String name;
    private String category;
    private int price;

    public Product(String name, Category category, int price) {
        this.name = name;
        this.category = category.name();
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }

    enum Category {
        FROZEN, DAIRY, BAKEDGOODS, OTHER
    }
}

package classstructureintegrate;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    //Getters:
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    //Increase method:
    public void increasePrice(int increase){
        price += increase;
    }

    //Decrease method:
    public void decreasePrice(int decrease){
        price -= decrease;
    }
}

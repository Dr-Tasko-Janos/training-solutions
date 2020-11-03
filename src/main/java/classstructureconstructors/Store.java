package classstructureconstructors;

public class Store {
    private String product;
    private int stock;

    //Constructor:
    public Store(String product){
        this.product = product;
        this.stock = 0; //Just for safety, but this is not necessary because the default value for stock is zero.
    }

    //Setters:
    public void store(int number){
        System.out.println("\nThe previous number of \"" + product + "\" products: " + stock);
        System.out.println("\tAdded products: " + number);
        this.stock += number;
        System.out.println( "\tNew amount of products: " + this.stock + "\n");
    }

    public void dispatch(int number){
        System.out.println("\nThe previous number of \"" + product + "\" products: " + stock);
        System.out.println("\tDispatched products: " + number);
        this.stock -= number;
        System.out.println( "\tNew amount of products: " + this.stock + "\n");

    }
}

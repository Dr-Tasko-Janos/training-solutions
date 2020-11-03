package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {

        String productName;
        int price,increase, decrease;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the product name: ");
        productName = scanner.nextLine();

        System.out.print("Enter the price of the product: ");
        price = scanner.nextInt();
        Product product = new Product(productName,price);

        System.out.println("\n" + "The name of the product: " + product.getName());
        System.out.println("The price of the product: " + product.getPrice() + "\n");

        //Increase:
        System.out.print("Enter the increase value: ");
        increase = scanner.nextInt();
        product.increasePrice(increase);
        System.out.println("The new increased price is: " + product.getPrice() + "\n");

        //Decrease:
        System.out.print("Enter the decrease value: ");
        decrease = scanner.nextInt();
        product.decreasePrice(decrease);
        System.out.println("The new decreased price is: " + product.getPrice() + "\n");

        scanner.close();

    }
}

package finalmodifier;

public class TaxCalculator {

    public static final double VAT = 0.27;

    public static double tax(double price) {
        return price * VAT;
    }

    public static double priceWithTax(double price) {
        return tax(price) + price;
    }

    public static void main(String[] args) {

        System.out.println("The size of VAT is: " + TaxCalculator.VAT +
                ", the price of the product is: 100");
        System.out.println("The calculated amount of VAT after the product price is: " + tax(100));
        System.out.println("The gross price of the product(included: VAT + price) is: " + priceWithTax(100));
    }
}

package week02d03;

public class Product {
    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public String getCode() {
        return this.code;
    }

    public boolean areTheyEqual(Product b) {
        return this.name.contentEquals(b.getName());
    }

    public boolean areTheyEqualStrict(Product b) {
        int counter = 0;

        if(this.code.length() - b.code.length() <=1 && this.code.length() - b.code.length() >= -1)


        if (this.code.length() == b.code.length()) {
            for (int i = 0; i < this.code.length(); i++) {
                if (this.code.charAt(i) != b.code.charAt(i)) {
                    counter++;
                }
            }
        }
        boolean flag = (counter > 0 && counter <= 1) ? true : false;

        return (areTheyEqual(b) && flag);
    }

    public static void main(String[] args) {
        Product product1 = new Product("Mars", "abc123");
        Product product2 = new Product("Mars", "def345");
        Product product3 = new Product("Mars", "abc1233");

        System.out.println("Product1 (name: " + product1.name + ", code: " + product1.code + ") and Product2 (name: " + product2.name + ", code: " + product2.code + ") compare with plain equal method: " + product1.areTheyEqual(product2));
        System.out.println("Product1 (name: " + product1.name + ", code: " + product1.code + ") and Product2 (name: " + product2.name + ", code: " + product2.code + ") compare with strict equal method: " + product1.areTheyEqualStrict(product2));
        System.out.println("Product1 (name: " + product1.name + ", code: " + product1.code + ") and Product3 (name: " + product3.name + ", code: " + product3.code + ") compare with strict equal method: " + product1.areTheyEqualStrict(product3));
    }
}

package attributes.bill;

public class BillMain {

    public static void main(String[] args) {

        Bill bills = new Bill();
        bills.addItem("A1", 12, 14.5);
        bills.addItem("A2", 10, 15.6);
        bills.addItem("A3", 120, 1.2);
        System.out.println(bills.items.size());
        System.out.println(bills.calculateTotalPrice());
    }
}

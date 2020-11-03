package classstructureconstructors;

import java.util.Scanner;

public class StoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Store store1 = new Store("Apple");
        Store store2 = new Store("Lemon");

        store1.store(12);
        store1.dispatch(2);
        store1.store(2);
        store1.dispatch(12);

        store2.store(240);
        store2.dispatch(140);
        store2.store(140);
        store2.dispatch(240);
    }
}

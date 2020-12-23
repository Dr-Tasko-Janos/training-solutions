package introconstructors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    private List<String> menu = new ArrayList<>();
    private String name;
    private int capacity;

    public Restaurant(String name, int numberOfTables) {
        this.name = name;
        this.capacity = 4 * numberOfTables;
        this.menu = menuCreator();
    }

    public List<String> menuCreator() {
        List<String> menu1 = new ArrayList<>();
        int numberOfDishes = 0;
        System.out.print("Enter the number of dishes you wish to add to the menu: ");
        Scanner scanner = new Scanner(System.in);
        numberOfDishes = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i <= numberOfDishes; i++) {
            System.out.print("Enter dish" + i + ": ");
            menu1.add(scanner.nextLine());
        }
        return menu1;
    }

    public List<String> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }
}

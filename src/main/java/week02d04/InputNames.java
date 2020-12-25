package week02d04;

import java.util.Scanner;

public class InputNames {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] names = new String[5];
        System.out.println("Enter five names!");
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter name " + i + ": ");
            names[i - 1] = scanner.nextLine();
        }
        System.out.println("\nHere are the names you typed in: ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(i + 1 + " " + names[i]);
        }
    }
}

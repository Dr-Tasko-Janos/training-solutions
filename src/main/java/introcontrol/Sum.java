package introcontrol;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        String listNumber = "";
        System.out.println("\nEnter five numbers and you'll receive their sum!");
        for (int i = 1; i <= 5; i++) {
            int tempNumber = 0;
            System.out.print("\tEnter number" + i + ": ");
            tempNumber = scanner.nextInt();
            sum += tempNumber;
            listNumber += (i < 5) ? tempNumber + ", " : tempNumber;
        }
        System.out.println("The sum of the five numbers (" + listNumber + ") you entered is: " + sum);
    }
}

package statements;

import java.util.Scanner;

public class DivByThree {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check is it divisible by 3 or not: ");
        number = scanner.nextInt();

        System.out.println(number + " is " + (number % 3 == 0 ? "" : "not ") + "divisible by 3!");
    }
}

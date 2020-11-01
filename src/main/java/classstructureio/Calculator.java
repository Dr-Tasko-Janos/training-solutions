package classstructureio;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int number1, number2, result;
        Scanner scanner = new Scanner(System.in);

        //Asking for the first number:
        System.out.print("Enter an integer value: ");
        number1 = scanner.nextInt();

        //Asking for the second number:
        System.out.print("Enter an other integer value: ");
        number2 = scanner.nextInt();

        //Assign the sum of the two values to the result variable:
        result = number1 + number2;

        //Display the result:
        System.out.println("The equation is the following: " + ((number1 < 0) ? "(" + number1 + ")" : number1) + " + " + ((number2 < 0) ? "(" + number2 + ")" : number2));
        System.out.println("The result is: " + result);

        //And finally closing the scanner:
        scanner.close();
    }
}

package statements;

import java.util.Scanner;

public class InvestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int fund, interestRate, days;

        System.out.print("Enter the amount of fund: ");
        fund = scanner.nextInt();
        System.out.print("Enter the value of the interest rate: ");
        interestRate = scanner.nextInt();

        Investment investment = new Investment(fund, interestRate);

        System.out.println("The amount you placed in the fund: " + investment.getFund());

        System.out.print("\nEnter the number of days to calculate the yield: ");
        days = scanner.nextInt();
        System.out.println("The yield after " + days + " is: " + investment.getYield(days));

        System.out.print("\nEnter the number of days till closing the fund: ");
        days = scanner.nextInt();
        if (days > 365) {
            System.out.println("You entered " + days + " which is higher than 365 so we will use 365 for the calculations!");
            days = 365;
        } else if (days < 1) {
            System.out.println("You entered " + days + " which is less than 1 so we will use 1 for the calculations!");
            days = 1;
        }
        System.out.println("The amount of  money (fund + yield - costs) after " + days + " days: " + investment.close(days));

        System.out.print("\nEnter the number of days till closing the fund: ");
        days = scanner.nextInt();
        if (days > 365) {
            System.out.println("You entered " + days + " which is higher than 365 so we will use 365 for the calculations!");
            days = 365;
        } else if (days < 1) {
            System.out.println("You entered " + days + " which is less than 1 so we will use 1 for the calculations!");
            days = 1;
        }
        System.out.println("The amount of  money (fund + yield - costs) after " + days + " days: " + investment.close(days));
    }
}

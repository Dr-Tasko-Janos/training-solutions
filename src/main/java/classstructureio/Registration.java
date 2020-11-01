package classstructureio;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        //Declare variables:
        String userName, emailAddress;
        Scanner scanner = new Scanner(System.in);

        //Get user name:
        System.out.print("Enter your full name (e.g. John Doe): ");
        userName = scanner.nextLine();

        //Get e-mail address:
        System.out.print("Enter your e-mail address (e.g. john.doe@mailbox.com): ");
        emailAddress = scanner.nextLine();

        //Print out the registered data:
        System.out.println("\nWe have registered the following data: ");
        System.out.println("\tYour user name: " + userName+ "\n\tYour e-mail address: " + emailAddress);

        //Closing the scanner:
        scanner.close();
    }
}

package stringtype.registration;

import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserValidator validator = new UserValidator();

        String username;
        String password;
        String emailAddress;

        while (true) {
            System.out.print("\nEnter a Username: ");
            String tempUsername = scanner.nextLine();
            if (validator.isValidUsername(tempUsername)) {
                username = tempUsername;
                System.out.println("Your Username is valid!");
                break;
            } else {
                System.out.println("Invalid Username! Please, enter a valid Username below!");
                continue;
            }
        }

        while (true) {
            System.out.print("\nEnter a Password: ");
            String tempPassword1 = scanner.nextLine();
            System.out.print("Enter the Password again: ");
            String tempPassword2 = scanner.nextLine();
            if (validator.isValidPassword(tempPassword1, tempPassword2)) {
                password = tempPassword1;
                System.out.println("Your password is valid!");
                break;
            } else {
                System.out.println("Invalid or not matching passwords! Please, enter a valid Password below!");
                continue;
            }
        }

        while (true) {
            System.out.print("\nEnter your E-mail address: ");
            String tempEmailAddress = scanner.nextLine();
            if (validator.isValidEmail(tempEmailAddress)) {
                emailAddress = tempEmailAddress;
                System.out.println("Your E-mail address is valid!");
                break;
            } else {
                System.out.println("Invalid E-mail address! Please, enter a valid E-mail address below!");
                continue;
            }
        }

        System.out.println("\n\nCongratulation! We registered the following credentials about you:");
        System.out.println("\tYour Username: " + username);
        System.out.print("\tYour password is: ");
        for (int i = 0; i < password.length(); i++) {
            System.out.print("*");
        }
        System.out.println("\n\tYour E-mail address: " + emailAddress + "\n");

    }
}

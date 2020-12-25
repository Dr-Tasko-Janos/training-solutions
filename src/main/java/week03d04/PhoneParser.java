package week03d04;

import java.util.Scanner;

public class PhoneParser {

    public static Phone parse() {
        String phoneNumberPuffer = null;

        System.out.print("Enter a phoneNumber (required format: 12-1234567):");

        Scanner scanner = new Scanner(System.in);
        phoneNumberPuffer = scanner.nextLine();

        Phone newPhoneNumber = new Phone(phoneNumberPuffer.substring(0, 2), phoneNumberPuffer.substring(3));

        return newPhoneNumber;
    }
}

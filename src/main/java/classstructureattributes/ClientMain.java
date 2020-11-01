package classstructureattributes;

import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        Client newClient = new Client();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the client's name (e.g. John Doe): ");
        newClient.name = scanner.nextLine();

        System.out.print("Enter the client's year of birth (e.g. 1980): ");
        newClient.year = scanner.nextInt();

        //To avoid empty address variable:
        scanner.nextLine();

        System.out.print("Enter the client's address (e.g. 1117 Budapest, Budafoki út 56.): ");
        newClient.address = scanner.nextLine();

        System.out.println("\n The client's registered data are the follows:  ");
        System.out.println("\tName: " + newClient.name +
                "\n\tYear of birth: " + newClient.year +
                "\n\tAddress: " + newClient.address);

        scanner.close();
    }
}

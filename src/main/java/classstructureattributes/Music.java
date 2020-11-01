package classstructureattributes;

import java.util.Scanner;

public class Music {
    public static void main(String[] args) {
        Song favouriteSong = new Song();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Think of your favourite song!");
        System.out.print("\tEnter the band\\singer's name: " );
        favouriteSong.band = scanner.nextLine();

        System.out.print("\tEnter the title of the song: ");
        favouriteSong.title = scanner.nextLine();

        System.out.print("\tEnter the length of the song: ");
        favouriteSong.length = scanner.nextDouble();

        System.out.print("\n" + favouriteSong.band + " - " + favouriteSong.title);
        System.out.printf(" (%s%.2f %s)", ((Math.abs(favouriteSong.length) < 10.0)? "0" : ""), Math.abs(favouriteSong.length), ((Math.abs(favouriteSong.length) <= 1.0)? " minute" : "minutes"));

        //closing the scanner:
        scanner.close();

        //To make display the System.out.print() and System.out.printf() statements above immediately,
        // to prevent the waiting for the next System.out.println() statement call.
        System.out.println("");
    }
}

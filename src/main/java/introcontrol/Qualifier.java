package introcontrol;

import java.util.Scanner;

public class Qualifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nAdjon meg egy számot: ");
        System.out.println("A megadott szám: " + ((scanner.nextInt() > 100) ? "nagyobb, mint száz" : "száz, vagy kisebb") + ".\n");
    }
}

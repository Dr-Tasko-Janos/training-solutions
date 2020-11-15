package introcontrol;

import java.util.Scanner;

public class BoatRental {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean boatFlag5 = false;
        boolean boatFlag3 = false;
        boolean boatFlag2 = false;

        int guests = 0;
        int onWaiting = 0;
        int guestsTemp = 0;

        System.out.print("\nEnter the number of the guests: ");
        guests = scanner.nextInt();
        guestsTemp = guests;

        if (guests == 10) {
            boatFlag5 = boatFlag3 = boatFlag2 = true;
            onWaiting = 0;
        } else if (guests > 10) {
            boatFlag5 = boatFlag3 = boatFlag2 = true;
            onWaiting = guestsTemp - 10;
        } else if (guestsTemp < 10 && guestsTemp >= 0) {
            for (int i = 5; i >= 1; i -= 2) {
                if ((guestsTemp / i) == 1 || (i == 1 && guestsTemp > 0)) {
                    if (i == 1) {
                        i++;
                    }
                    if (i == 5) {
                        boatFlag5 = true;
                        guestsTemp -= i;
                    } else if (i == 3) {
                        boatFlag3 = true;
                        guestsTemp -= i;
                    } else {
                        boatFlag2 = true;
                        guestsTemp -= i;
                    }

                }
            }
        }
        if (guests <= 0) {
            System.out.println("ERROR! The number of guests must be greater than 0(zero)!");
        } else {
            System.out.println("The number of guests is: " + guests);
            System.out.println("The boats on the water:\n" +
                    ((boatFlag5) ? "\t* 5-seater boat\n" : "") +
                    ((boatFlag3) ? "\t* 3-seater boat\n" : "") +
                    ((boatFlag2) ? "\t* 2-seater boat\n" : ""));
            System.out.println("Number of guests on waiting: " + onWaiting);
        }
    }
}

package statements;

import java.util.Scanner;

public class TimeMain {
    public static void main(String[] args) {
        int hours, minutes, seconds;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the the following details for Time1: ");
        System.out.print("\tEnter the hour(s): ");
        hours = scanner.nextInt();
        System.out.print("\tEnter the minute(s): ");
        minutes = scanner.nextInt();
        System.out.print("\tEnter the second(s): ");
        seconds = scanner.nextInt();
        Time time1 = new Time(hours, minutes, seconds);

        System.out.println("\n\nEnter the the following details for Time2: ");
        System.out.print("\tEnter the hour(s): ");
        hours = scanner.nextInt();
        System.out.print("\tEnter the minute(s): ");
        minutes = scanner.nextInt();
        System.out.print("\tEnter the second(s): ");
        seconds = scanner.nextInt();
        Time time2 = new Time(hours, minutes, seconds);

        System.out.print("\n\nTime1 is: ");
        time1.tostring();
        System.out.println("Time1 is: " + time1.getMinutes() + " in minutes.");

        System.out.print("\n\nTime2 is: ");
        time2.tostring();
        System.out.println("Time2 is: " + time2.getInSeconds() + " in seconds.");

        System.out.println("\nIs Time1 is earlier than Time2: " + time1.earlierThan(time2));
    }
}

package week02;

import java.util.Scanner;

public class Controller {

    private static Scanner scanner = new Scanner(System.in);
    private Office office = new Office();
    private Boolean flag = true;

    public static void main(String[] args) {
        Controller controller = new Controller();

        controller.readOffice();

        while (true) {
            if (controller.flag) {
                controller.printMenu();
                continue;
            }
            break;
        }
        scanner.close();
    }


    public void readOffice() {
        System.out.print("Enter the number of meeting rooms you want to register: ");
        int numberOfRoom = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numberOfRoom; i++) {
            System.out.print("\nEnter the name of the \"meeting room " + (i + 1) + "\": ");
            String name = scanner.nextLine();
            System.out.print("Enter the length in meter of \"" + name + "\" meeting room: ");
            int length = scanner.nextInt();
            System.out.print("Enter the width in meter of " + name + " meeting room: ");
            int width = scanner.nextInt();
            scanner.nextLine();

            office.addMeetingRoom(new MeetingRoom(name, length, width));
        }
    }

    public void printMenu() {
        Controller controller = new Controller();
        System.out.print(
                "\n\n*** Select one of the following functions: ***\n\n" +
                        "\t1. Meeting rooms in order of registration\n" +
                        "\t2. Meeting rooms in reverse order of registration\n" +
                        "\t3. Every second meeting room\n" +
                        "\t4. Areas\n" +
                        "\t5. Search by exact meeting room name\n" +
                        "\t6. Search by a fragment of meeting room name\n" +
                        "\t7. Search by meeting room area\n" +
                        "\t__________________________\n" +
                        "\t0 Exit\n\n" +
                        "Select: ");
        int answer = scanner.nextInt();

        switch (answer) {
            case 1:
                office.printNames();
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 2:
                office.printNamesReverse();
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 3:
                scanner.nextLine();
                office.printEventNames();
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                break;
            case 4:
                scanner.nextLine();
                office.printAreas();
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                break;
            case 5:
                System.out.print("\nEnter the exact name of the meeting room: ");
                scanner.nextLine();
                office.printMeetingRoomsWithName(scanner.nextLine());
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                break;
            case 6:
                System.out.print("\nEnter a substring that contained by a meeting room name: ");
                scanner.nextLine();
                office.printMeetingRoomsContains(scanner.nextLine());
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                break;
            case 7:
                System.out.print("\nEnter a meeting room area value in m\u00B2: ");
                office.printAreasLargerThan(scanner.nextInt());
                System.out.print("\n Press \"Enter\" to continue");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case 0:
                System.out.println("\nYou are closing the program!");
                scanner.close();
                System.exit(0);
        }
    }
}





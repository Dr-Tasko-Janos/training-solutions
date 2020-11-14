package introdate;

import java.util.Scanner;

public class EmployeeTest {
    public static void main(String[] args) {
        String name;
        int year, month, day;

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nEnter the name of the employee: ");
        name = scanner.nextLine();
        System.out.println("Enter the employee's: ");
        System.out.print("\t year of birth(e.g. 1850): ");
        year = scanner.nextInt();
        System.out.print("\t month of birth(e.g. 12): ");
        month = scanner.nextInt();
        System.out.print("\t day of birth(e.g. 31): ");
        day = scanner.nextInt();

        Employee employee = new Employee(year, month, day, name);

        System.out.println("\nThe employee's: ");
        System.out.println("\t name: " + employee.getName());
        System.out.println("\t date of birth: " + employee.getDateOfBirth());
        System.out.println("\t starting date of employment is: " + employee.getBeginEmployment());

        System.out.println("\n\nChanging the employee's name.");
        System.out.print("\tEnter a new name for the employee: ");
        scanner.nextLine();
        employee.setName(scanner.nextLine());
        scanner.close();
        System.out.println("\nThe employee's: ");
        System.out.println("\t new name: " + employee.getName());
        System.out.println("\t date of birth: " + employee.getDateOfBirth());
        System.out.println("\t starting date of employment: " + employee.getBeginEmployment());

    }
}

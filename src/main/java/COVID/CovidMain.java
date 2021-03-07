package COVID;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;

public class CovidMain {

    static int citizen_id = new CovidDao().lastPatientIdFinder();

    public static void main(String[] args) {

        MariaDbDataSource dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306:/covid?useUnicode=true");
            dataSource.setUser("covidUser");
            dataSource.setPassword("covidUser");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("DataSource create error", sqle);
        }

        int chosenOption;

        while (true) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("\n\n\n\t\t\t *** OPTIONS ***\n");
            System.out.println("0. EXIT(Kilépés a porgramból)\n");
            System.out.println("1. Registration(Regisztráció)");
            System.out.println("2. Mass Registration(Tömeges regisztráció)");
            System.out.println("3. Generate Query List(Generálás)");
            System.out.println("4. Vaccination(Oltás)");
            System.out.println("5. Failed Vaccination(Oltás meghiúsulás)");
            System.out.println("6. Riport");

            System.out.print("\nType the number of the chosen option from above: ");

            inner:
            while (true) {
                if (scanner.hasNextInt()) {
                    chosenOption = scanner.nextInt();

                    if (chosenOption >= 0 && chosenOption <= 6) {

                        switch (chosenOption) {
                            case 1:
                                new SingleRegistration().singleRegistration();
                                scanner.nextLine();
                                break inner;
                            case 2:
                                new MassRegistration().massRegistraton();
                                scanner.nextLine();
                                break inner;
                            case 3:
                                new GenerateListToDailyVaccination().generateListToDailyVaccination();
                                scanner.nextLine();
                                System.out.println();
                                break inner;
                            case 4:
                                new Vaccination().vaccination();
                                scanner.nextLine();
                                System.out.println();
                                break inner;
                            case 6:
                                new Riport().riport();
                                scanner.nextLine();
                                System.out.println();
                                break inner;
                            case 0:
                                System.out.println("The program is Exit.");
                                scanner.close();
                                System.exit(0);
                        }
                    } else {
                        System.out.printf("\nInput must between 0(included) and 6(included). The given value was: %d.\n" +
                                "Try again or press 0 to Exit the program.\n\n", chosenOption);
                        break inner;
                    }
                } else {
                    System.out.println("\n\nInteger input is required! You entered:Try again or press 0 to EXIT!");
                    break inner;
                }
            }
        }
    }
}






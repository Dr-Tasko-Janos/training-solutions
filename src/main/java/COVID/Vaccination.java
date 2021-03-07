package COVID;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Vaccination {


    public void vaccination() {

        boolean flagForRun = true;
        int counter = 0;
        String errorCause = "Unknown error";
        String ssn = null;
        int chosenOption = 0;
        int citizenId = 0;
        int vaccinationStatus = 0;
        long daysBetween = 0L;

        String citizenName = "";
        int numberOfVaccination = 0;
        Date lastVaccinationDate = Date.valueOf(LocalDate.now());
        String vaccineType = "";
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n[4. Vaccination(Oltás)]\nEnter the following data:");


        wholeValidation:
        while (flagForRun) {

            ssnValidation:
            while (true) {

                System.out.print("\tEnter the Social Security Number(SSN) of the patient: ");

                String pufferSsn = scanner.nextLine();
                boolean validationIndicator = false;
                int validationNumber = 0;

                if (!new CovidOtherMethods().isSsnValidForVaccination(pufferSsn)) {


                    System.out.printf("\n\nValid Social Security Number(SSN) required! Valid Ssn number must have a length at 9 characters and must contain only inteer values! %d/3 chance%s left before throw back to Main Menu!\n\n", (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid Social Security Number(SSN) input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    ssn = pufferSsn;
                    counter = 0;

                    try (Connection conn = new CovidDao().getDataSource().getConnection();
                         PreparedStatement stmt = conn.prepareStatement("select citizen_name, number_of_vaccination, " +
                                 "last_vaccination, vaccination_type, cit.citizen_id " +
                                 "from citizens as cit " +
                                 "inner join vaccinations as vac " +
                                 "on cit.citizen_id = vac.citizen_id " +
                                 "where ssn = ? ")) {
                        stmt.setString(1, ssn);

                        try (ResultSet rs = stmt.executeQuery()) {
                            if (rs.next()) {
                                citizenName = rs.getString("citizen_name");
                                numberOfVaccination = rs.getInt("number_of_vaccination");
                                lastVaccinationDate = rs.getDate("last_vaccination");
                                vaccineType = rs.getString("vaccination_type");
                                citizenId = rs.getInt("citizen_id");
                            }
                        } catch (SQLException sqle) {
                            throw new IllegalArgumentException("Error caused by executeQuery", sqle);
                        }
                    } catch (
                            SQLException sqle) {
                        throw new IllegalArgumentException("Error cause by SQL Query", sqle);
                    }
                }
                System.out.printf("\nPatient name: %s(SSN: %s)", citizenName, ssn);

                if (numberOfVaccination == 2) {
                    System.out.printf("\n%s (SSN: %s) has already got %s %s on %s", citizenName, ssn, (vaccineType.equals("Johnson & Johnson")) ? "" : "the second dose  of ", vaccineType, lastVaccinationDate);
                    flagForRun = false;
                    break wholeValidation;
                }

                if (numberOfVaccination == 1) {
                    if (new CovidDao().isAdequateTimeElapsed(ssn)) {


                        System.out.printf("\n%s (SSN: %s) has already got %s on %s so MUST GET AGAIN: %s", citizenName, ssn, vaccineType, lastVaccinationDate, vaccineType);
                        vaccinationStatus = 2;
                        new CovidDao().vaccinationUpdater(++numberOfVaccination, vaccineType, ssn, vaccinationStatus, citizenId);

                    } else {
                        System.out.println("\nAdequate time must elapse between two vaccination which must be at least 15 days.");
                    }
                    flagForRun = false;
                    break wholeValidation;
                }

                if (numberOfVaccination == 0) {
                    inner1:
                    while (true) {

                        System.out.println("\n\n\n\t\t\t *** Available Vaccine Types ***\n");
                        System.out.println("0. EXIT into MAIN Menu(Visszalépés a főmenübe)\n");
                        System.out.println("1." + TypeOfVaccine.values()[0].getName());
                        System.out.println("2." + TypeOfVaccine.values()[1].getName());
                        System.out.println("3." + TypeOfVaccine.values()[2].getName());
                        System.out.println("4." + TypeOfVaccine.values()[3].getName());
                        System.out.println("5." + TypeOfVaccine.values()[4].getName());
                        System.out.println("6." + TypeOfVaccine.values()[5].getName());

                        System.out.print("\nType the number of the chosen option from above: ");

                        inner2:
                        while (true) {
                            if (scanner.hasNextInt()) {
                                chosenOption = scanner.nextInt();

                                if (chosenOption >= 0 && chosenOption <= 6) {

                                    switch (chosenOption) {
                                        case 1:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 1;
                                            scanner.nextLine();
                                            break inner1;
                                        case 2:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 1;
                                            scanner.nextLine();
                                            break inner1;
                                        case 3:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 1;
                                            scanner.nextLine();
                                            System.out.println();
                                            break inner1;
                                        case 4:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 1;
                                            scanner.nextLine();
                                            break inner1;
                                        case 5:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 1;
                                            scanner.nextLine();
                                            break inner1;
                                        case 6:
                                            vaccineType = TypeOfVaccine.values()[chosenOption - 1].getName();
                                            vaccinationStatus = 2;
                                            scanner.nextLine();
                                            System.out.println();
                                            break inner1;
                                        case 0:
                                            System.out.println("Drop to Main Menu");
                                            scanner.close();
                                            flagForRun = false;
                                            break wholeValidation;
                                    }
                                } else {
                                    System.out.printf("\nInput must between 0(included) and 6(included). The given value was: %d.\n" +
                                            "Try again or press 0 to Exit to the Main Menu.\n\n", chosenOption);
                                    break inner2;
                                }
                                //Nevezzük majd át VaccinationValidation-re a végén
                                break ssnValidation;
                            }
                        }
                    }
                    System.out.printf("You registered the following data:\n" +
                                    "Patient name: %s(SSN: %s)\n" +
                                    "Number of vaccination: %d\n" +
                                    "Vaccine type: %s\n" +
                                    "Vaccination status: %d\n" +
                                    "Vaccination time stamp(automatically generated): %s"
                            , citizenName, ssn, 1 + numberOfVaccination, vaccineType, vaccinationStatus, LocalDateTime.now().toString());

                    new CovidDao().vaccinationUpdater(1 + numberOfVaccination, vaccineType, ssn, vaccinationStatus, citizenId);
                    flagForRun = false;
                    break wholeValidation;
                }
            }
            if (flagForRun == true) {
                System.out.println(errorCause);
            }
        }
    }
}


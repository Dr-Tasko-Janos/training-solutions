package COVID;

import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class MassRegistration {

    public void massRegistraton() {

        Scanner scanner = new Scanner(System.in);
        String errorCause = "Unknown error happened";
        String pathOfPatientsList = null;
        String line = null;
        boolean flagForRun = true;
        int lineCounter = 0;

        List<String> inCaseTransactionForSsnValidation = new ArrayList<>();
        Set<String> idThatExists = new CovidDao().queryPostCodesExists();

        String name = null;
        int postCode = 0000;
        int age = 0;
        String email = null;
        String ssn = null;

        System.out.println("\n\n[2. Tömeges regisztráció]\nEnter the following data:");

        wholeValidation:
        while (flagForRun) {

            System.out.print("\nGive me the path of the list of patients: ");
            pathOfPatientsList = scanner.nextLine();

            Path file = Path.of(pathOfPatientsList);

            MariaDbDataSource dataSource = new CovidDao().getDataSource();

            try (Connection conn = dataSource.getConnection()) {

                conn.setAutoCommit(false);

                BufferedReader reader = Files.newBufferedReader(file);
                while ((line = reader.readLine()) != null) {
                    String[] lineArray = line.split(";");
                    lineCounter++;

                    if (lineCounter == 1) {
                        continue;
                    }

                    for (int i = 0; i <= 4; i++) {
                        switch (i) {
                            //name validation
                            case (0):
                                if (new CovidOtherMethods().isNameValid(lineArray[i])) {
                                    name = lineArray[i];
                                } else {
                                    errorCause = "Invalid name(\"" + lineArray[i] + "\") at line: " + lineCounter + ".";
                                    conn.rollback();
                                    break wholeValidation;
                                }
                                break;
                            //postCode validation
                            case (1):
                                if (new CovidOtherMethods().castingTextToNumberChecker(lineArray[i])) {
                                    postCode = Integer.parseInt(lineArray[i]);
                                } else {
                                    errorCause = "Invalid postCode(\"" + lineArray[i] + "\") at line: " + lineCounter + ".";
                                    conn.rollback();
                                    break wholeValidation;
                                }
                                break;
                            //age validation
                            case (2):
                                if (new CovidOtherMethods().isAgeValid(Integer.parseInt(lineArray[i]))) {
                                    age = Integer.parseInt(lineArray[i]);
                                } else {
                                    errorCause = "Invalid age(\"" + lineArray[i] + "\") at line: " + lineCounter + ".";
                                    conn.rollback();
                                    break wholeValidation;
                                }
                                break;
                            //email validation
                            case (3):
                                if (new CovidOtherMethods().isEmailValid(lineArray[i])) {
                                    email = lineArray[i];
                                } else {
                                    errorCause = "Invalid e-mail address(\"" + lineArray[i] + "\") at line: " + lineCounter + ".";
                                    conn.rollback();
                                    break wholeValidation;
                                }
                                break;
                            //Social Security Number validation
                            case (4):
                                if (new CovidOtherMethods().isSsnValid(lineArray[i]) & !idThatExists.contains(lineArray[i])) {
                                    ssn = lineArray[i];
                                    idThatExists.add(ssn);
                                } else {
                                    errorCause = "\nInvalid Social Security Number(SSN)(\"" + lineArray[i] + "\") at line: " + lineCounter + ".";
                                    conn.rollback();
                                    break wholeValidation;
                                }
                                break;
                        }
                    }
                    new CovidDao().registerPatient(conn, name, postCode, age, email, ssn);
                }
                conn.commit();
            } catch (IOException ioe) {
                throw new IllegalStateException("File can not read", ioe);
            } catch (SQLException sqle) {
                throw new IllegalStateException("Can not create connection", sqle);
            }
            flagForRun = false;
        }
        if (flagForRun == true) {

            System.out.println(errorCause);
        }
    }
}
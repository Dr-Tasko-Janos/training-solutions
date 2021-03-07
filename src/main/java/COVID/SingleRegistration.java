package COVID;

import java.util.Scanner;

public class SingleRegistration {

    public void singleRegistration() {

        String name = null;
        int postCode;
        int age;
        String email;
        String ssn = null;

        int counter = 0;
        boolean flagForRun = true;
        String errorCause = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n[1. Regisztáció]\nEnter the following data:");

        wholeValidation:
        while (flagForRun) {

            nameValidation:
            while (true) {

                System.out.print("\tname: ");
                String pufferName = scanner.nextLine();
                if (!(new CovidOtherMethods().isNameValid(pufferName))) {
                    System.out.printf("\n\nValid name required! You gave the following input: \"%s\"\n" +
                            "%d/3 chance%s left before throw back to Main Menu!\n\n", pufferName, (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid name input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    name = pufferName.trim();
                    counter = 0;
                    break nameValidation;
                }
            }

            postCodeValidation:
            while (true) {

                System.out.print("\tpostCode: ");
                String pufferPostCode = scanner.nextLine();


                if (!(new CovidOtherMethods().castingTextToNumberChecker(pufferPostCode))) {
                    System.out.printf("\n\nValid postCode required! " +
                            "\nYou left blank the postCode field or the given post code contains other characters than numbers!" +
                            "\n %d/3 chance%s left before throw back to Main Menu!\n\n", (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid postCode input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    postCode = Integer.parseInt(pufferPostCode);
                    counter = 0;
                    break postCodeValidation;
                }
            }

            ageValidation:
            while (true) {

                System.out.print("\tage: ");
                int pufferAge = scanner.nextInt();

                if (!(new CovidOtherMethods().isAgeValid(pufferAge))) {
                    System.out.printf("\n\nValid age required between 11(included) and 149(included)! " +
                            "\nYou gave the following input: \"%d\"\n" +
                            "%d/3 chance%s left before throw back to Main Menu!\n\n", pufferAge, (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid age input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    age = pufferAge;
                    counter = 0;
                    scanner.nextLine();
                    break ageValidation;
                }
            }

            emailValidation:
            while (true) {

                System.out.print("\te-mail address: ");
                String pufferEmail1 = scanner.nextLine();
                System.out.print("\tRepeat e-mail address: ");
                String pufferEmail2 = scanner.nextLine();

                if (!(new CovidOtherMethods().isEmailValid(pufferEmail1)) || !pufferEmail1.equals(pufferEmail2)) {
                    System.out.printf("\n\nValid Email address required! \nValid Email address must have:" +
                                    "\n\t- a length at least 3 character and " +
                                    "\n\t- must contain an \"@\" symbol and \n\t" +
                                    "- the two given email address must be  same!" +
                                    "\n %d/3 chance%s left before throw back to Main Menu!\n\n",
                            (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid Email address input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    email = pufferEmail1.trim();
                    counter = 0;
                    break emailValidation;
                }
            }

            ssnValidation:
            while (true) {
                System.out.print("\tSocial Security Number: ");
                String pufferSsn = scanner.nextLine();
                boolean validationIndicator = false;
                int validationNumber = 0;

                if (!new CovidOtherMethods().isSsnValid(pufferSsn)) {


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
                    break ssnValidation;
                }
            }

            System.out.printf("\n\nYou entered the following data:\n " +
                            "\tname: %s \n\tpostCode (settlement): %d (%s) \n\tage: %d \n\te-mail: %s \n\tSocial Security Number: %s",
                    name, postCode, new CovidDao().settlementFromPostcode(new CovidDao().getDataSource(), postCode), age, email, ssn);

            new CovidDao().registerPatient(name, postCode, age, email, ssn);
            flagForRun = false;
        }
        if (flagForRun == true) {
            System.out.println(errorCause);
        }
    }
}

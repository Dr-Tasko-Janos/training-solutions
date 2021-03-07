package COVID;


import java.util.Scanner;

public class GenerateListToDailyVaccination {


    public void generateListToDailyVaccination() {

        boolean flagForRun = true;
        int counter = 0;
        String errorCause = null;
        int postCode;
        String fileName = null;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n[3. Generate Query List(Generálás)]\nEnter the following data:");

        wholeValidation:
        while (flagForRun) {

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

            fileNameValidation:
            while (true) {

                System.out.print("\tgive a filename: ");
                String pufferFileName = scanner.nextLine();


                if (!(new CovidOtherMethods().isFileNameValid(pufferFileName))) {
                    System.out.printf("\n\nValid postCode required! " +
                            "\nYou left blank the postCode field or the given post code contains other characters than numbers!" +
                            "\n %d/3 chance%s left before throw back to Main Menu!\n\n", (3 - (counter + 1)), (counter <= 1) ? "s" : "");

                    if (counter == 2) {
                        System.out.println("Invalid input happened 3 times");
                        errorCause = "Invalid fileName input for three times";
                        break wholeValidation;
                    }
                    counter++;
                    continue;

                } else {
                    fileName = pufferFileName + ".txt";
                    counter = 0;
                    break fileNameValidation;
                }
            }

            System.out.printf("You entered the following Post Code: %s and filename: \"%s\"  for the generated file which contains the information of patients who involved by vaccination program at the present day", postCode, fileName);
           new CovidDao().queryForVaccinationByPosteCodeIntoFile(fileName, postCode);
            flagForRun = false;
        }
        if (flagForRun == true) {
            System.out.println(errorCause);
        }
    }
}

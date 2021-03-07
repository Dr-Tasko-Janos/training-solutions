package COVID;

public class CovidOtherMethods {

    public Boolean castingTextToNumberChecker(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNameValid(String name) {
        return (!name.isEmpty() && !name.isBlank() && name != null) ? true : false;
    }

    public boolean isFileNameValid(String fileName) {
        return (!fileName.isEmpty() && !fileName.isBlank() && fileName != null && !fileName.contains(".")) ? true : false;
    }

    public boolean isAgeValid(int age) {
        return (age > 10 && age < 150) ? true : false;
    }

    public boolean isEmailValid(String email) {
        return (email.length() > 3 && email.contains("@")) ? true : false;
    }

    public boolean isSsnValid(String ssn) {
        int validationNumber = 0;
        boolean validationIndicator = false;
        if (new CovidOtherMethods().castingTextToNumberChecker(ssn)) {
            for (int i = 0; i < 8; i += 2) {
                validationNumber += (Integer.parseInt(ssn.substring(i, i + 1)) * 3);
            }

            for (int i = 1; i < 8; i += 2) {
                validationNumber += (Integer.parseInt(ssn.substring(i, i + 1)) * 7);
            }

            validationIndicator = (validationNumber % 10 == Integer.parseInt(ssn.substring(8))) ? true : false;
        }
        return ((new CovidOtherMethods().castingTextToNumberChecker(ssn)) && ssn.length() == 9 && validationIndicator && !(new CovidDao().isSsnExists(new CovidDao().getDataSource(), ssn)));
    }
}


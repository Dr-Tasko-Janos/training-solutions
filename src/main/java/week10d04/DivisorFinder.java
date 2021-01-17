package week10d04;

public class DivisorFinder {

    public int findDivisor(int n) {
        String numberInString = Integer.toString(n);
        String[] numberInStringArray = numberInString.split("");

        int counter = 0;

        for (String item : numberInStringArray) {
            if (n % Integer.parseInt(item) == 0) {
                counter++;
            }
        }
        return counter;
    }
}

package week07d02;

public class DigitSum {

    public static int sumOfDigits(int x) {
        int sum = 0;
        String numberInString = Integer.toString(x);
        String[] numberInStringArray = numberInString.split("");
        for (String item : numberInStringArray) {
            sum += Integer.parseInt(item);
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println(sumOfDigits(123));
    }
}

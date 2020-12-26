package week08d05;

public class MathAlgorithms {

    public static int greatestCommonDivisor(int number1, int number2) {
        int gcd = 1;
        int max = Math.min(number1, number2);

        for (int i = 1; i <= max; i++) {
            if (number1 % i == 0 && number2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void main(String[] args) {
        System.out.println(greatestCommonDivisor(28, 12));
    }
}

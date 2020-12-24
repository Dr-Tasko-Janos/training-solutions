package week07d01;

public class MathAlgorithms {

    public static boolean isPrime(int x) {
        if (x < 1) {
            throw new IllegalArgumentException("The value must be larger than 0!");
        }
        int conditionNumber = (x > 4) ? (int) Math.sqrt(x) : x;
        boolean flag = true;
        for (int i = 2; i < conditionNumber; i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {

        System.out.println(isPrime(17));
    }
}

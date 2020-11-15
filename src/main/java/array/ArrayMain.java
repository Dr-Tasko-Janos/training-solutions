package array;

public class ArrayMain {
    public static void main(String[] args) {

        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println("\nThe second element of the \"day of the week\" array is: " + daysOfWeek[1]);
        System.out.println("The length of the \"day of the week\" array is: " + daysOfWeek.length);

        int[] powersOfTwo = new int[5];
        System.out.println("\nThe powers of two from 0 to 4:\n");
        for (int i = 0; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = (int) Math.pow(2.0, i);
            System.out.println((i == powersOfTwo.length - 1) ? ("\t2^" + i + " = " + powersOfTwo[i]) : ("\t2^" + i + " = " + powersOfTwo[i] + ", "));
        }

        boolean[] myBoolArray = new boolean[6];
        System.out.println("\nThe elements of the \"myBoolArray\" array are the following: ");
        for (int i = 0; i < myBoolArray.length; i++) {
            myBoolArray[i] = (i % 2 == 0) ? false : true;
            System.out.print(i + ": " + ((i == myBoolArray.length - 1) ? myBoolArray[i] + "\n" : myBoolArray[i] + ", "));
        }
    }
}

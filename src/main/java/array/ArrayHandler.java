package array;

import java.util.Arrays;

public class ArrayHandler {

    public boolean contains(int[] source, int itemToFind) {
        for (int item : source) {
            if (item == itemToFind) {
                return true;
            }
        }
        return false;
    }

    public int find(int[] source, int itemToFind) {
        for (int i = 0; i < source.length; i++) {
            if (source[i] == itemToFind) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] testArray = {1, 5, 2, 7, 3, 4};
        int testValue1 = 4;
        int testValue2 = 6;

        ArrayHandler arrayHandler = new ArrayHandler();

        System.out.println("The test values are the following:\n\t\"testValue1\": " + testValue1 + "\n\t\"testValue2\": " + testValue2);
        System.out.println("The test \"testArray\" contains  the following values: " + Arrays.toString(testArray));

        System.out.println("\nTesting the \"contains\" method: ");
        System.out.println("\tIs testArray contains " + testValue1 + ": " + arrayHandler.contains(testArray, testValue1));
        System.out.println("\tIs testArray contains " + testValue2 + ": " + arrayHandler.contains(testArray, testValue2));

        System.out.println("\nTesting the \"find\" method: ");
        System.out.println("\tWhat is the index number of " + testValue1 + ": " + arrayHandler.find(testArray, testValue1));
        System.out.println("\tWhat is the index number of " + testValue2 + ": " + arrayHandler.find(testArray, testValue2));


    }


}

package week07d03;

import java.util.Arrays;
import java.util.List;

public class NumberList {

    public static boolean isIncreasing(List<Integer> integerList) {
        int echo = 0;
        for (Integer item : integerList) {
            if (item == echo) {
                continue;
            } else if (item < echo) {
                return false;
            }
            echo = item;
        }
        return true;
    }

    public static void main(String[] args) {

        List<Integer> myListInOrder = Arrays.asList(0, 1, 2, 18, 24, 25, 128);
        List<Integer> myListInOrderWithDuplicatedValue = Arrays.asList(0, 1, 2, 2, 18, 24, 25, 128);

        List<Integer> myListNotInOrder = Arrays.asList(0, 1, 2, 24, 25, 18, 128);
        List<Integer> myListNotInOrderWithDuplicatedValue = Arrays.asList(0, 1, 2, 2, 24, 25, 18, 128);

        System.out.println("is myListInOrder in order: " + isIncreasing(myListInOrder));
        System.out.println("is myListInOrderWithDuplicatedValue in order: " + isIncreasing(myListInOrder));

        System.out.println("is myListNotInOrder in order: " + isIncreasing(myListNotInOrder));
        System.out.println("is myListNotInOrderWithDuplicatedValue in order: " + isIncreasing(myListNotInOrder));
    }
}

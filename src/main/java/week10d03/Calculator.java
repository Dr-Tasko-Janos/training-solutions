package week10d03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Calculator {


    public int findMinSum(int[] numberArray) throws LessThanFourException {

        if (numberArray.length < 4) {
            throw new LessThanFourException();
        }

        List<Integer> numberList = new ArrayList<Integer>();

        for (int item : numberArray) {
            if (!numberList.contains(item)) {
                numberList.add(item);
            }
        }

        Collections.sort(numberList);

        int[][] twoDimensionalNumberArray = new int[numberList.size()][numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            twoDimensionalNumberArray[0][i] = numberList.get(i);
        }

        for (int item : numberArray) {
            for (int i = 0; i < twoDimensionalNumberArray.length; i++) {
                if (item == twoDimensionalNumberArray[0][i]) {
                    twoDimensionalNumberArray[1][i] += 1;
                }
            }
        }

        String number = "";
        int maxValueIndex = 0;
        int maxValue = 0;
        int counter = 0;

        marked:
        for (int i = 0; i < twoDimensionalNumberArray.length; i++) {
            for (int j = 0; j < twoDimensionalNumberArray[1][i]; j++) {
                number += twoDimensionalNumberArray[0][i];
                counter++;
                if (counter == 4) {
                    break marked;
                }
            }
        }
        return Integer.parseInt(number);
    }
}

class LessThanFourException extends Exception {
    @Override
    public String toString() {
        return "Length of the parameter Array shuld not be less than four(4)";
    }
}











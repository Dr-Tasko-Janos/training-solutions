package week10d02;

import java.util.ArrayList;
import java.util.List;

public class MaxTravel {

    public int getMaxIndex(int[] numberArray) throws OverThirtyException {
        if (numberArray.length > 30) {
            throw new OverThirtyException();
        }

        List<Integer> numberList = new ArrayList<Integer>();

        for (int item : numberArray) {
            if (!numberList.contains(item)) {
                numberList.add(item);
            }
        }

        int[][] twoDimensionalNumberArray = new int[numberList.size()][numberList.size()];
        for (int i = 0; i < numberList.size(); i++) {
            twoDimensionalNumberArray[0][i] = numberList.get(i);
        }


        for (int item : numberArray) {
            for (int i = 0; i < twoDimensionalNumberArray.length; i++) {
                if (item == twoDimensionalNumberArray[0][i]) {
                    twoDimensionalNumberArray[1][i] += 1;
                    //continue;
                }
            }
        }

        int maxValueIndex = 0;
        int maxValue = 0;

        for (int i = 0; i < twoDimensionalNumberArray.length; i++) {
            if (twoDimensionalNumberArray[1][i] > maxValue) {
                maxValueIndex = i;
                maxValue = twoDimensionalNumberArray[1][i];
            }
        }

        return twoDimensionalNumberArray[0][maxValueIndex];
    }
}

class OverThirtyException extends Exception {
    @Override
    public String toString() {
        return "Number of Array Elements should not be greater than 30";
    }
}

package week06d01;

import java.util.Arrays;
import java.util.List;

public class ListSelector {

    public String everySecondElement(List<String> list) {
        String resultString = "[";

        if (list == null) {
            throw new IllegalArgumentException("The given list has a null value");
        } else if (list.size() == 0) {
            return "";
        } else {
            for (int i = 0; i < list.size(); i += 2) {
                resultString += (i == list.size() - 2) ? list.get(i) + "]" : list.get(i) + ", ";  //Here is the solution for the Bonus task :-)
            }
        }
        return resultString;
    }

    public static void main(String[] args) {

        ListSelector listSelector = new ListSelector();

        List<String> numbers = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten");

        System.out.println(listSelector.everySecondElement(numbers));
    }
}

package week05d03;

import java.util.List;

public class ListCounter {

    public int listCounter(List<String> myList) {
        int counter = 0;
        for (String item : myList) {
            if ((item.startsWith("a") || item.startsWith("A")) || (item.endsWith("a") || item.endsWith("A"))) {
                counter++;
            }
        }
        return counter;
    }
}

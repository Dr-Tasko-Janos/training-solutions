package week05d03;

import java.util.List;

public class ListCounter {

    public int listCounter(List<String> myList) {
        int counter = 0;
        for (String item : myList) {
            if(item.toUpperCase().startsWith("A")){
            //if (item.startsWith("a") || item.startsWith("A")) {
            // ---> In case when last character matching is important too
            // if ((item.startsWith("a") || item.startsWith("A")) || (item.endsWith("a") || item.endsWith("A"))) {
                counter++;
            }
        }
        return counter;
    }
}

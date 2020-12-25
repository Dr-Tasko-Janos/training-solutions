package week04d02;

import java.util.ArrayList;
import java.util.List;

public class Search {

    public static List<Integer> getIndexesOfSearch(String word, char character) {
        String charString = Character.toString(character);
        String[] wordArray = word.split("");
        List<Integer> listOfIndexes = new ArrayList<>();

        for (int i = 0; i < wordArray.length; i++) {
            if (wordArray[i].equals(charString)) {
                listOfIndexes.add(i);
            }
        }
        return listOfIndexes;
    }

    public static void main(String[] args) {

        System.out.println(getIndexesOfSearch("almafa", 'a'));
    }
}

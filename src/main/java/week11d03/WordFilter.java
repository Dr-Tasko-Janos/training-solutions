package week11d03;

import java.util.ArrayList;
import java.util.List;

public class WordFilter {

    public List<String> wordsWithChar(List<String> words, char c) {
        List<String> listToReturn = new ArrayList<>();
        String toFind = Character.toString(c);
        for (String word : words) {
            if (word.contains(toFind)) {
                listToReturn.add(word);
            }
        }
        return listToReturn;
    }

    public static void main(String[] args) {

        List<String> words = List.of("szilva", "barack", "alma", "körte", "banán", "naspolya", "meggy");
        WordFilter wordFilter = new WordFilter();
        System.out.println(wordFilter.wordsWithChar(words, 'a').toString());
    }
}

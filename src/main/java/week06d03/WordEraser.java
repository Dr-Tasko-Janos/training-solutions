package week06d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordEraser {

    public String eraseWord(String words, String word){

        List<String> wordsList = Arrays.asList(words.split(" "));

        List<String> newStringList = new ArrayList<>();
        for(int i = 0; i < wordsList.size(); i++){
            if(wordsList.get(i).equals(word)){
                continue;
            }
            newStringList.add(wordsList.get(i));
        }
        return String.join(" ", newStringList);
        }

    public static void main(String[] args) {

        WordEraser wordEraser = new WordEraser();

        System.out.println(wordEraser.eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
    }
}


package week05d02;

import java.util.Arrays;
import java.util.List;

public class ChangeLetter {

    public static String changeVowels(String text) {
        final List<Character> vowels = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        char[] textArray = text.toCharArray();
        for (int i = 0; i < textArray.length; i++) {
            if (vowels.contains(textArray[i])) {
                textArray[i] = '*';
            }
        }
        return new String(textArray);
    }

    public static void main(String[] args) {
        System.out.println(changeVowels("HEllo"));
    }
}


package week08d03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringLists {

    public static List<String> stringListUnion(List<String> first, List<String> second) {
        List<String> unionList = new ArrayList<>();

        List<String> firstInOrder = new ArrayList<>(first);
        Collections.sort(firstInOrder);

        List<String> secondInOrder = new ArrayList<>(second);
        Collections.sort(secondInOrder);

        String buffer = null;

        for (String item : firstInOrder) {
            if (item.equals(buffer)) {
                continue;
            }
            unionList.add(item);
            buffer = item;
        }

        for (String item : secondInOrder) {
            if (unionList.contains(item)) {
                continue;
            }
            unionList.add(item);
        }

        Collections.sort(unionList);
        return unionList;
    }

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("apple", "apple", "peach", "lemon", "mango", "apricot");
        List<String> list2 = Arrays.asList("kiwi", "strawberry", "peach", "lemon", "mango", "apricot", "pineapple", "watermelon", "blackberry");

        System.out.println(stringListUnion(list1, list2));
    }
}

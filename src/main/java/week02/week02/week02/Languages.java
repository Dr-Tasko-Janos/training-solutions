package week02.week02.week02;

import java.util.ArrayList;
import java.util.List;

public class Languages {

    public static void main(String[] args) {
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("JavaScript");

        for(String i : languages){
            if(i.length() > 5){
                System.out.println(i);
            }
        }
    }
}

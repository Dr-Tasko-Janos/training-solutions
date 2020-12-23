package finalmodifier;

import java.util.Arrays;
import java.util.List;

public class Week {

    //Bonus task2:
    public final String name;

    public Week(String name) { //In the constructor we can initialize the final type attribute
        this.name = name;
    }

    public static void main(String[] args) {

        List<String> daysOfTheWeek = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        List<String> wednesday = Arrays.asList("Wednesday");
        //daysOfTheWeek.get(1) = daysOfTheWeek.get(2); It is not working!

        //It is a great success! :-)
        List<String> daysOfTheWeek2;
        daysOfTheWeek2 = wednesday;
        System.out.println(daysOfTheWeek2);

        //Bonus task2:

        final String dogName;
        dogName = "Héra";  //We can initialize a final type local variable later in the program
        System.out.println(dogName);
    }
}

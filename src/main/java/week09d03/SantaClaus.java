package week09d03;

import java.util.ArrayList;
import java.util.List;

public class SantaClaus {

    private List<Person> persons = new ArrayList<Person>();

    public SantaClaus(List<Person> persons) {
        this.persons = persons;
    }

    public void getThroughChimneys() {
        for (Person person : persons) {
            person.setPresent();
        }
    }

    public void getPersons() {
        for (Person item : persons) {
            System.out.println(item);
        }
    }
}

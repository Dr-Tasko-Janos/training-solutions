package week09d03;

import java.util.Arrays;
import java.util.List;

public class SantaClausRunner {

    public static void main(String[] args) {

        Person person1 = new Person("John Doe", 18);
        Person person2 = new Person("Jack Doe", 12);
        Person person3 = new Person("Jill Doe", 34);

        List<Person> testList = Arrays.asList(person1, person2, person3);


        SantaClaus santaClaus = new SantaClaus(testList);
        santaClaus.getPersons();
        santaClaus.getThroughChimneys();
        santaClaus.getPersons();
    }
}


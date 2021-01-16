package week09d03;

import java.util.Random;

public class Person {

    private String name;
    private int age;
    private Present present;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setPresent() {
        Random random = new Random();
        int indexOfPresent = random.nextInt(4);
        int indexOfPresentFinal = (age > 14 && indexOfPresent == 0) ? ++indexOfPresent : indexOfPresent;
        present = Present.values()[indexOfPresentFinal];
    }

    @Override
    public String toString() {
        return name + " " + age + " " + present;
    }
}

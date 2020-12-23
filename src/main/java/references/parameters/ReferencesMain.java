package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {

        Person person1;
        Person person2;
        person1 = new Person("John Doe", 1980);
        person2 = person1;

        person2.setName("Jack Doe");

        System.out.println("The content of the person1 variable: ");
        System.out.println(person1.getName());
        System.out.println(person1.getAge());

        System.out.println("\nThis is because both variable has the same reference.\n");

        System.out.println("The content of the person2 variable: ");
        System.out.println(person2.getName());
        System.out.println(person2.getAge());

        int number1;
        int number2;
        number1 = 24;
        number2 = number1;
        number2++;

        System.out.println("\n\nThis is because the two variable is independent of each other.");

        System.out.println("The value of number1: " + number1);
        System.out.println("The value of number2: " + number2);
    }


}

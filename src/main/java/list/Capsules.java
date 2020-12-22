package list;

import java.util.ArrayList;
import java.util.List;

public class Capsules {

    private List<String> capsules = new ArrayList<>();

    public void addLast(String color) {
        capsules.add(color);
    }

    public void addFirst(String color) {
        capsules.add(0, color);
    }

    public void removeFirst() {
        capsules.remove(0);
    }

    public void removeLast() {
        capsules.remove(capsules.size() - 1);
    }

    ;

    public List<String> getColors() {
        return capsules;
    }

    public static void main(String[] args) {

        Capsules capsules = new Capsules();

        System.out.println(capsules.getColors());

        capsules.addFirst("yellow");
        System.out.println(capsules.getColors());
        capsules.addFirst("blue");
        System.out.println(capsules.getColors());
        capsules.addLast("orange");
        System.out.println(capsules.getColors());
        capsules.addLast("green");
        System.out.println(capsules.getColors());
        capsules.removeFirst();
        System.out.println(capsules.getColors());
        capsules.removeLast();
        System.out.println(capsules.getColors());


        //Solving Bonus1 task:
        System.out.println("\nSolving Bonus1 task:");
        List<String> newCapsules = capsules.getColors();
        System.out.println("Items inside newCaspsules List: " + newCapsules.toString());
        System.out.println("Items inside the original capsules List: " + capsules.getColors());
        System.out.println("\nApplication of the clear() method on the newCapsules list and  check the result of it:\n");
        newCapsules.clear();
        System.out.println("Items inside of the newCapsules List: " + newCapsules.toString());
        System.out.println("Items inside of the original capsules List: " + capsules.getColors());

    }
}

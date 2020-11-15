package week02;

import java.util.Scanner;

public class Phone {
    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        String type1, type2;
        int mem1, mem2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter the details about phone1:");
        System.out.print("\tEnter the type: ");
        type1 = scanner.nextLine();
        System.out.print("\tEnter the mem: ");
        mem1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nEnter the details about phone2:");
        System.out.print("\tEnter the type: ");
        type2 = scanner.nextLine();
        System.out.print("\tEnter the mem: ");
        mem2 = scanner.nextInt();

        Phone phone1 = new Phone(type1, mem1);
        Phone phone2 = new Phone(type2, mem2);
        System.out.println("\nType of phone1: " + phone1.getType());
        System.out.println("Mem of phone1: " + phone1.getMem());
        System.out.println("\nType of phone2: " + phone2.getType());
        System.out.println("Mem of phone2: " + phone2.getMem());
    }
}

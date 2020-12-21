package arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArraysMain {

    //numberOfDaysAsString method implementation:
    public String numberOfDaysAsString() {
        int[] numberOfDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return Arrays.toString(numberOfDays);
    }

    //daysOfWeek method implementation:
    public List<String> daysOfWeek() {
        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        return Arrays.asList(dayOfWeek);
    }

    //multiplicationTableAsString method implementation:
    public String multiplicationTableAsString(int size) {
        System.out.println("\t" + size + " times (" + size + "x) Multiplication Table:\n");

        int[][] multiplicationTable = new int[size][size];

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);
            }
        }
        return Arrays.deepToString(multiplicationTable);
    }
    //sameTempValues method implementation:
    public String sameTempValues(double[] day, double[] anotherDay){
        boolean flag = Arrays.equals(day, anotherDay);
        if(flag){
            return "The two days have the same measured temperature values.";
        }
          return "The two day have different measured temperature values.";
    }
/*
    //Bonus method implementation:

    sameTempValuesDaylight(double[] day, double[] anotherDay){
        int sizeDay = day.length;
        int sizeAnotherDay = day.length;

        boolean flag = sizeDay > sizeAnotherDay;

        int greatestIndex = (flag) ? day.length : anotherDay.length;

        

    }*/



    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        Scanner scanner = new Scanner(System.in);

        System.out.println("numberOfDaysAsString method result:\n" + arraysMain.numberOfDaysAsString());

        System.out.println("\ndaysOfWeek method result:\n" + arraysMain.daysOfWeek());

        System.out.println("\nmultiplicationTableAsString method result:");
        System.out.print("\tEnter the size of the multiplication table: ");
        System.out.println(arraysMain.multiplicationTableAsString(scanner.nextInt()));

        scanner.close();
    }
}

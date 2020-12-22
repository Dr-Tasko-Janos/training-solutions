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
    public String sameTempValues(double[] day, double[] anotherDay) {
        boolean flag = Arrays.equals(day, anotherDay);
        if (flag) {
            return "The two days have the same measured temperature values.";
        }
        return "The two day have different measured temperature values.";
    }

    //wonLottery method implementation:

    public boolean wonLottery(int[] winningNumbers, int[] myNumbers) {
        boolean flag = false;
        Arrays.sort(winningNumbers);
        Arrays.sort(myNumbers);
        if (Arrays.equals(winningNumbers, myNumbers)) {
            flag = true;
        }
        return flag;
    }

    public boolean wonLotteryWithoutSideEffects(int[] winningNumbers, int[] myNumbers) {
        boolean flag = false;
        int[] winningNumbersx = new int[winningNumbers.length];
        System.arraycopy(winningNumbers, 0, winningNumbersx, 0, winningNumbers.length);
        int[] myNumbersx = Arrays.copyOf(myNumbers, myNumbers.length);
        Arrays.sort(winningNumbersx);
        Arrays.sort(myNumbersx);
        if (Arrays.equals(winningNumbers, myNumbers)) {
            flag = true;
        }
        return flag;
    }


    //Bonus method implementation:

    public void sameTempValuesDaylight(double[] day, double[] anotherDay) {
        boolean flag = false;

        int shortestDay = shortestDay(day.length, anotherDay.length);

        double[] dayx = Arrays.copyOfRange(day, 0, shortestDay);
        double[] anotherDayx = Arrays.copyOfRange(anotherDay, 0, shortestDay);

        System.out.println("\nCalling sameTempValues method by: sameTempValuesDaylight method: ");
        System.out.println(sameTempValues(dayx, anotherDayx));
    }

    public int shortestDay(int day1, int day2) {
        return (day1 < day2) ? day1 : day2;
    }


    public static void main(String[] args) {
        ArraysMain arraysMain = new ArraysMain();
        Scanner scanner = new Scanner(System.in);

        System.out.println("numberOfDaysAsString method result:\n" + arraysMain.numberOfDaysAsString());

        System.out.println("\ndaysOfWeek method result:\n" + arraysMain.daysOfWeek());

        System.out.println("\nmultiplicationTableAsString method result:");
        System.out.print("\tEnter the size of the multiplication table: ");
        System.out.println(arraysMain.multiplicationTableAsString(scanner.nextInt()));


        int[] winningNumbers = {31, 24, 35, 67, 89};
        int[] myNumbers = {13, 87, 34, 56, 9};
        System.out.println("\n\n\nThe implementation o the wonLottery method: \n\nOriginal order of the winning numbers: " + Arrays.toString(winningNumbers));
        System.out.println("Original order of myNumbers: " + Arrays.toString(myNumbers));
        System.out.println("Did I win the lottery? " + arraysMain.wonLottery(winningNumbers, myNumbers));
        System.out.println("Order of winning Numbers after the wonLottery method: " + Arrays.toString(winningNumbers));
        System.out.println("Order of myNumbers after the wonLottery method: " + Arrays.toString(myNumbers));

        int[] winningNumbersx = {31, 24, 35, 67, 89};
        int[] myNumbersx = {13, 87, 34, 56, 9};
        System.out.println("\n\n\nThe implementation o the wonLottery without side effect method: \n\nOriginal order of the winning numbers: " + Arrays.toString(winningNumbersx));
        System.out.println("Original order of myNumbers: " + Arrays.toString(myNumbersx));
        System.out.println("Did I win the lottery? " + arraysMain.wonLotteryWithoutSideEffects(winningNumbersx, myNumbersx));
        System.out.println("Order of winning Numbers after the wonLotteryWithoutSideEffects method: " + Arrays.toString(winningNumbersx));
        System.out.println("Order of myNumbers after the wonLotteryWithoutSideEffects method: " + Arrays.toString(myNumbersx));

        //Testing the sameTempValuesDaylight method:

        System.out.println("\n\nTesting the sameTempValuesDayligth method: ");
        double[] dayValues1 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0};
        double[] dayValues2 = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0, 14.0, 15.0, 16.0, 17.0, 18.0, 19.0, 20.0, 21.0, 22.0, 23.0, 24.0, 25.0};
        arraysMain.sameTempValuesDaylight(dayValues1, dayValues2);
        scanner.close();
    }
}

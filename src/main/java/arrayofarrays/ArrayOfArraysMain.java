package arrayofarrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayOfArraysMain {
    public static void main(String[] args) {

        //Print timetable:
        Scanner scanner = new Scanner(System.in);
        ArrayOfArraysMain arrayOfArraysMain = new ArrayOfArraysMain();

        System.out.print("\nEnter the size of the multiplication table: ");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.multiplicationTable(scanner.nextInt()));


        //Print out the elements of a multi dimensional Array into separated lines:
        System.out.println("\n\nPress a button to continue with the test of the \"printArrayOfArrays\" -method.");
        scanner.nextLine();
        scanner.nextLine();

        System.out.println("Task: Display the inner Array elements of a Multidimensional-Array in separate lines.");
        int[][] testArray = {{1}, {1, 2}, {1, 2, 3}};
        System.out.println("Here is the test array:\n" + Arrays.deepToString(testArray));
        System.out.println("\tPress a button to continue...");
        scanner.nextLine();
        System.out.println("Here is the elements of the given Multidimensional-Array in separate lines:");
        arrayOfArraysMain.printArrayOfArrays(testArray);

        System.out.println("\n\nPress a button to continue with the test of the \"triangularMatrix\" -method.");
        scanner.nextLine();
        System.out.print("Enter the size of the triangular-matrix table: ");
        arrayOfArraysMain.printArrayOfArrays(arrayOfArraysMain.triangularMatrix(scanner.nextInt()));
        System.out.println("\tPress a button to continue...");
        scanner.nextLine();
        scanner.nextLine();

        //Bonus Task 1.
        System.out.print("\nHere is the test of the \"The Bonus Task 1.\". For test purpose, enter the size of the multiplication table:");
        arrayOfArraysMain.printArrayOfArraysBonus(arrayOfArraysMain.multiplicationTable(scanner.nextInt()));

        scanner.close();

    }

    public int[][] multiplicationTable(int size) {
        System.out.println("\n" + size + " times (" + size + "x) Multiplication Table:\n");

        int[][] multiplicationTable = new int[size][size];

        for (int i = 0; i < multiplicationTable.length; i++) {
            for (int j = 0; j < multiplicationTable[i].length; j++) {
                multiplicationTable[i][j] = (i + 1) * (j + 1);

                //In case we want to print out the elements without calling any external method
                // System.out.print((j == multiplicationTable.length - 1) ? (multiplicationTable[i][j] + "\n") : (multiplicationTable[i][j] + "\t"));
            }
        }
        return multiplicationTable;
    }

    public void printArrayOfArrays(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print((j == a[i].length - 1) ? (+a[i][j] + "\n") : (a[i][j] + "\t"));
            }
        }
    }

    public int[][] triangularMatrix(int size) {
        System.out.println("\nLower triangular matrix (or left triangular matrix) of " + size + " lines:\n");
        int[][] triangularMatrix = new int[size + 1][];
        for (int i = 0; i < size + 1; i++) {
            triangularMatrix[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangularMatrix[i][j] = i;
            }
        }
        return triangularMatrix;
    }

    //Bonus Task 1 implementation:
    public void printArrayOfArraysBonus(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] >= 100) {
                    System.out.print((j == a[i].length - 1) ? ("_" + a[i][j] + "\n") : ("_" + a[i][j]));
                } else if (a[i][j] >= 10) {
                    System.out.print((j == a[i].length - 1) ? ("__" + a[i][j] + "\n") : ("__" + a[i][j]));
                } else {
                    System.out.print((j == a[i].length - 1) ? ("___" + a[i][j] + "\n") : ("___" + a[i][j]));
                }
            }
        }
        System.out.println("\nThe result above, with whitespace characters: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] >= 100) {
                    System.out.print((j == a[i].length - 1) ? (" " + a[i][j] + "\n") : (" " + a[i][j]));
                } else if (a[i][j] >= 10) {
                    System.out.print((j == a[i].length - 1) ? ("  " + a[i][j] + "\n") : ("  " + a[i][j]));
                } else {
                    System.out.print((j == a[i].length - 1) ? ("   " + a[i][j] + "\n") : ("   " + a[i][j]));
                }
            }
        }
    }
}



package week10d03;

public class CalculatorRunner {


    public static void main(String[] args) {

        int[] intArray = {8, 13, 2, 5, 5, 7, 13, 13, 13, 9, 6, 9, 9, 7, 5, 9, 12, 13, 13, 13, 5, 5, 5, 1, 5, 5, 5, 5, 5, 5};
        int[] intArray2 = {8, 13, 2};

        Calculator calculator = new Calculator();

        try
        {
            System.out.println(calculator.findMinSum(intArray));
        }
        catch (LessThanFourException e)
        {
            System.out.println(e);
        }
    }
}


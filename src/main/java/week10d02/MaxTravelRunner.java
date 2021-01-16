package week10d02;

public class MaxTravelRunner {

    public static void main(String[] args) {

        int[] intArray = {8, 13, 2, 5, 5, 7, 13, 13, 13, 9, 6, 9, 9, 7, 5, 9, 12, 13, 13, 13, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};

        MaxTravel travellers = new MaxTravel();

        try
        {
            System.out.println(travellers.getMaxIndex(intArray));
        }
        catch (OverThirtyException e)
        {
            System.out.println(e);
        }
    }
}

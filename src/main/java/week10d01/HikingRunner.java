package week10d01;

import java.util.Arrays;
import java.util.List;

public class HikingRunner {

    public static void main(String[] args) {

        Hiking hiking = new Hiking();

        List<Double> positiveElevation = Arrays.asList(10.0, 20.0, 15.0, 18.0);

        System.out.println("The value of the positive evaluation was: " + hiking.getPlusElevation(positiveElevation));
    }
}

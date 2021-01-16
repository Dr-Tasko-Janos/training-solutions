package week10d01;

import java.util.List;

public class Hiking {

    private static double positiveElevation = 0.0;

    public static double getPlusElevation(List<Double> heightsValues) {
        double puffer = heightsValues.get(0);

        for (Double item : heightsValues) {
            if (item > puffer) {
                positiveElevation += item - puffer;
            }
            puffer = item;
        }
        return positiveElevation;
    }
}

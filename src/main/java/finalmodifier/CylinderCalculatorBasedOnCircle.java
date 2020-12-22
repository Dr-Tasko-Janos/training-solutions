package finalmodifier;

import java.math.BigDecimal;

public class CylinderCalculatorBasedOnCircle {

    public static double calculateVolume(double radius, double height) {
        return CircleCalculator.calculateArea(radius) * height;
    }

    public static double calculateSurfaceArea(double radius, double height) {
        return CircleCalculator.calculateArea(radius) * 2 + CircleCalculator.calculatePerimeter(radius) * height;
    }

    //Bonus task4: Float and double data type can't provide such a precise value as BigDecimal
    public static void main(String[] args) {

        CircleCalculator circleCalculator = new CircleCalculator();

        System.out.println("Float and double data type can't provide such a precise value as BigDecimal.");

        System.out.println("\nThe result with using double data type: ");
        System.out.println(circleCalculator.calculatePerimeter(10.0));

        BigDecimal radius = new BigDecimal("10.0");
        BigDecimal pi = new BigDecimal("3.14");
        BigDecimal result = (radius.multiply(pi)).multiply(new BigDecimal("2"));
        System.out.println("\nThe result with using BigDecimal data type: ");
        System.out.println(result);
    }

}

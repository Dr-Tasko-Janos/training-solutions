package finalmodifier;

// import static finalmodifier.CircleCalculator.PI;   This can be a way, how to import the PI value from the CircleCalculator method

public class CylinderCalculator {

    public static double calculateVolume(double radius, double height) {
        return Math.pow(radius, 2.0) * CircleCalculator.PI * height;
    }

    public static double calculateSurfaceArea(double radius, double height) {
        return CircleCalculator.calculateArea(radius) * 2 + CircleCalculator.calculatePerimeter(radius) * height;
    }
}

package finalmodifier;

public class PiMain {

    public static void main(String[] args) {

        System.out.println("If radian = 4.0, the perimeter of the circle is: " + CircleCalculator.calculatePerimeter(4.0));
        System.out.println("If radian = 4.0, the area of the circle is: " + CircleCalculator.calculateArea(4.0));

        System.out.println("\nIf radian = 4.0, and the height of the cylinder is 25.0: the volume of the cylinder is: " + CylinderCalculator.calculateVolume(4.0, 25.0));
        System.out.println("If radian = 4.0, and the height of the cylinder is 25.0: the surface of the cylinder is: " + CylinderCalculator.calculateSurfaceArea(4.0, 25.0));

        System.out.println("\nHere is the value of PI: " + CircleCalculator.PI);
    }


}

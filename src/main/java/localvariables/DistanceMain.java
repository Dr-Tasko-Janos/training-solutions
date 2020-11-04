package localvariables;

public class DistanceMain {

    public static void main(String[] args) {

        Distance distance = new Distance(122.6, true);

        System.out.println(distance.distanceInKm);
        System.out.println(distance.isExact());

        int wholeDistanceInKm = (int) distance.getDistanceInKm();
        System.out.println(wholeDistanceInKm);

    }
}

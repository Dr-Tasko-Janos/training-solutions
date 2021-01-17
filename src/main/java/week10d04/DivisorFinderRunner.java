package week10d04;

public class DivisorFinderRunner {

    public static void main(String[] args) {

        DivisorFinder divisorFinder = new DivisorFinder();

        System.out.println("in case 259: " + divisorFinder.findDivisor(259));
        System.out.println("in case 425: " + divisorFinder.findDivisor(425));
        System.out.println("in case 279: " + divisorFinder.findDivisor(279));
        System.out.println("in case 472: " + divisorFinder.findDivisor(472));
        System.out.println("in case 222: " + divisorFinder.findDivisor(222));
        System.out.println("in case 432: " + divisorFinder.findDivisor(432));
    }
}

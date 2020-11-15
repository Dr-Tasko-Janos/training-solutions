package introdate;

public class PerformanceTest {
    public static void main(String[] args) {
        Performance performance = new Performance();

        System.out.println("\nArtist: " + performance.getArtist());
        System.out.println("Date: " + performance.getDate());
        System.out.println("Start time: " + performance.getStartTime());
        System.out.println("End time: " + performance.getEndTime());
        System.out.println("\nThe output of getInfo method: ");
        performance.getInfo();
    }
}

package introdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private LocalDate date;
    private String artist;
    private LocalTime startTime;
    private LocalTime endTime;

    public Performance() {
        date = LocalDate.of(1989, 06, 02);
        artist = "Queen";
        startTime = LocalTime.of(18, 00);
        endTime = LocalTime.of(20, 00);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getArtist() {
        return artist;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void getInfo() {
        System.out.println(artist + ": " + date + " " + startTime + " - " + endTime);
    }
}

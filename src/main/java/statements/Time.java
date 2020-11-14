package statements;

public class Time {

    private int hour, minute, second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public int getMinutes() {
        return (hour * 60) + minute;
    }

    public int getInSeconds() {
        return getMinutes() * 60 + second;
    }

    public boolean earlierThan(Time time) {
        return time.getInSeconds() > getInSeconds();
    }

    public void tostring() {
        System.out.print(hour + ":" + minute + ":" + second + "\n");
    }
}

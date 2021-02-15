package exam03;

public class Boat {

    private String name;

    private int maxPassenger;

    public Boat (String name, int maxPassenger) {
        this.name = name;
        this.maxPassenger = maxPassenger;
    }

    public String getName() {
        return name;
    }

    public int getMaxPassenger() {
        return maxPassenger;
    }
}

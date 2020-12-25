package week03d02;

import java.util.Arrays;
import java.util.List;

public class Position {

    private String name;
    private int bonus;

    public Position(String name, int bonus) {
        this.name = name;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "position name: " + name + " - bonus: " + bonus + "HUF";
    }

    public static void main(String[] args) {

        Position position1 = new Position("java programmer", 1_000_000);
        Position position2 = new Position("C programmer", 151_000);
        Position position3 = new Position("C# programmer", 100_000);

        List<Position> positionList = Arrays.asList(position1, position2, position3);

        for (Position item : positionList) {
            if (item.bonus > 150_000) {
                System.out.println(item);
            }
        }
    }
}

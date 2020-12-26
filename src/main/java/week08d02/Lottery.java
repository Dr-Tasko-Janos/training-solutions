package week08d02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Lottery {

    public static List<Integer> getNumbers() {
        Random random = new Random();
        List<Integer> winningNumbersList = new ArrayList<>();
        int randomBuffer;
        int counter = 1;
        while (counter <= 5) {
            randomBuffer = random.nextInt(90) + 1;
            if (winningNumbersList.contains(randomBuffer)) {
                continue;
            }
            winningNumbersList.add(randomBuffer);
            counter++;
        }
        Collections.sort(winningNumbersList);
        return winningNumbersList;
    }

    public static void main(String[] args) {
        System.out.println(getNumbers());
    }
}

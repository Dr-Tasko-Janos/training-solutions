package exam03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Histogram {

    public static void main(String[] args) {

        Scanner scanner = null;
        Path file = Path.of("histogram.txt");
        List<Integer> numbers = new ArrayList<>();

        try {
            scanner = new Scanner(Histogram.class.getResourceAsStream("numbers.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int number = Integer.parseInt(line);
                numbers.add(number);
            }

        } catch (NumberFormatException e) {
            throw new IllegalStateException("Invalid number", e);
        } catch (NullPointerException e) {
            throw e;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i : numbers) {
            try {
                writer.write("*".repeat(i) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

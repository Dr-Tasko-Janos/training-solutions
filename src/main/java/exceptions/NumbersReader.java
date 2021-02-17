package exceptions;

import java.util.Scanner;

public class NumbersReader {

    public static void main(String[] args) {

        Scanner scanner = null;
        try {
            scanner = new Scanner(NumbersReader.class.getResourceAsStream("numbers_.txt"));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int number = Integer.parseInt(line);
                System.out.println(number);
            }
        } catch (NumberFormatException nfe) {
            // System.out.println("Invalid number format");
            throw nfe;
        } catch (NullPointerException npe) {
            // System.out.println("File not found");
            throw new IllegalStateException("File not found", npe);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}


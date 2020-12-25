package week04d03;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {  //Bonus version

    public static void guessTheNumber() {

        Random random = new Random();
        int randomNumber = random.nextInt(101);
        int guess;

        System.out.println("I have a number between 0 and 100. Guess what is it. You have 5 attempts.");

        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter your " + i + ". attempt: ");
            guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("You figured out the number! Congratulation dude!!");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Your guess is less than my number!");
                System.out.println((i < 5) ? 5 - i + " turn have remained to figure out my number!" : "You lost the game! My number was: " + randomNumber);
                continue;
            } else {
                System.out.println("Your guess is above  my number!");
                System.out.println((i < 5) ? 5 - i + " turn have remained to figure out my number!" : "You lost the game! My number was: " + randomNumber);
            }
        }
    }

    public static void main(String[] args) {

        guessTheNumber();
    }
}


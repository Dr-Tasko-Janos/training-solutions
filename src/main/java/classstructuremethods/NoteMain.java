package classstructuremethods;

import java.util.Scanner;

public class NoteMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Note newNote = new Note();

        System.out.print("Enter your Name: ");
        newNote.setName(scanner.nextLine());

        System.out.print("Enter the Topic of the note: ");
        newNote.setTopic(scanner.nextLine());

        System.out.print("Type here your Note: ");
        newNote.setText(scanner.nextLine());

        scanner.close();

        System.out.println("\nHere comes your note: ");
        System.out.println(newNote.getNoteText());

    }
}

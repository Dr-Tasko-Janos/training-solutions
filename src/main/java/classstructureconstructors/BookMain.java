package classstructureconstructors;

public class BookMain {

    public static void main(String[] args) {

        //Creating an instance of Book class:
        Book newBook = new Book("Émile Zola", "Nana");

        //Recording of the registration number(regNumber):
        newBook.register("ÉZ-001");

        //Checking registered data:
        System.out.println("Author: " + newBook.getAuthor());
        System.out.println("Title: " + newBook.getTitle());
        System.out.println("Registration number: " + newBook.getRegNumber());

    }
}

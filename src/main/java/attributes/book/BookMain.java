package attributes.book;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book("Nana");
        System.out.println(book.getTitle());

        book.setTitle("Winnie The Pooh");

        System.out.println(book.getTitle());
    }
}

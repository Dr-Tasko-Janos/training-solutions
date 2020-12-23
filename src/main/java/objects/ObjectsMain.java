package objects;

public class ObjectsMain {

    public static void main(String[] args) {
        new Books(); //It is a valid statement, but I will not be able to reach it.

        System.out.println(new Books()); //It gives back a memory address

        Books emptyBook;
        // System.out.println(emptyBook);  //It not has been initialized

        emptyBook = null;
        System.out.println(emptyBook);  //It prints out null
        System.out.println(emptyBook == null);

        Books book = new Books();
        System.out.println(book);

        Books anotherBook = new Books();

        System.out.println(book == anotherBook);

        anotherBook = book;
        System.out.println(anotherBook == book);

        System.out.println(anotherBook instanceof Books);
    }
}

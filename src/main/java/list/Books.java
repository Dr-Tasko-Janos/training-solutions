package list;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<String> books = new ArrayList();

    public void add(String newBook) {
        books.add(newBook);
    }

    public List<String> findAllByPrefix(String prefix) {
        List<String> listByPrefix = new ArrayList<>();
        for (String item : books) {
            if (item.startsWith(prefix)) {
                listByPrefix.add(item);
            }
        }
        return listByPrefix;
    }

    public List<String> getTitles() {
        return books;
    }

    public static void main(String[] args) {

        Books myBooks = new Books();

        System.out.println(myBooks.getTitles());
        myBooks.add("Az aranyember");
        myBooks.add("Nana");
        myBooks.add("Az elveszett paradicsom");
        myBooks.add("Micimackó");
        System.out.println(myBooks.getTitles());
        System.out.println("The result for \"Az e\" prefix: " + myBooks.findAllByPrefix("Az e"));
        System.out.println("The result for \"Az \" prefix: " + myBooks.findAllByPrefix("Az "));

        //Testing Bonus Task2 implementation:

        System.out.println("\n\nTesting Bonus Task2 implementation:");
        System.out.println("Here is the original List: " + myBooks.getTitles());
        System.out.println("Content of books List after using the removeByPrefix method with the parameter of: \"Na\": ");
        myBooks.removeByPrefix("Na ");
        System.out.print(myBooks.getTitles());
        System.out.println("As you can see, nothing has happened!");

        System.out.println("Trying with removeAll method implemented to the removeByPrefixWithRemoveAll method: ");
        System.out.println("Here is the original myBooks List: " + myBooks.getTitles());
        myBooks.removeByPrefixWithRemoveAll("Na");
        System.out.println("Content of books List after using the removeByPrefixWithRemoveAll method with the parameter of: \"Na\": " + myBooks.getTitles());

    }

    //Bonus Task2 implementation:

    public void removeByPrefix(String prefix) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).startsWith(prefix)) {
                books.remove(i);
            }
        }
    }

    //The final solution for the Bonus Task2: :-)
    public void removeByPrefixWithRemoveAll(String prefix) {
        books.removeAll(findAllByPrefix(prefix));
    }
}

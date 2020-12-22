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
    }
}

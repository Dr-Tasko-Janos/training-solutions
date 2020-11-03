package classstructureconstructors;

public class Book {
    private String author, title, regNumber;

    //Constructor:
    public Book (String author, String title){
        this.author = author;
        this.title = title;
    }


    public void register (String regNumber){
        this.regNumber = regNumber;
    }

    //Getters:
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
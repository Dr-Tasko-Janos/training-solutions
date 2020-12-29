package catalog;

import java.util.ArrayList;
import java.util.List;

public class PrintedFeatures implements Feature {
    private List<String> authors = new ArrayList<>();
    private int numberOfPages;
    private String title;


    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Title must not be empty!");
        }
        this.title = title;

        if(numberOfPages <= 0){
            throw   new IllegalArgumentException("NUmber of pages must be a positive integer number!");
        }
        this.numberOfPages = numberOfPages;

        if(Validators.isEmpty(authors)){
            throw new IllegalArgumentException("Authors must not be empty!");
        }
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributorAuthors = new ArrayList<>(authors);
       // Collections.sort(contributorAuthors);
        return List.copyOf(contributorAuthors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

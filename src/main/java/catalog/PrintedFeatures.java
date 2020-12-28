package catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintedFeatures implements Feature {

    private List<String> authors = new ArrayList<>();
    private int numberOfPages;
    private String title;


    public PrintedFeatures(String title, int numberOfPages, List<String> authors) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributorAuthors = new ArrayList<>(authors);
        Collections.sort(contributorAuthors);
        return List.copyOf(contributorAuthors);
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}

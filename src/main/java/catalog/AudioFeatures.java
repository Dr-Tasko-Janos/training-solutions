package catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AudioFeatures {

    private int length;
    private String title;
    private List<String> performers = new ArrayList<>();
    private List<String> composer = new ArrayList<>();

    public AudioFeatures(String title, int length, List<String> performers) {
        this.title = title;
        this.length = length;
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);
        this.composer = composer;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();

        for (String performer : performers) {
            contributors.add(performer + "(P)");
        }

        for (String composeR : composer) {
            contributors.add(composeR + "(C)");
        }

        Collections.sort(contributors);
        return contributors;
    }
}

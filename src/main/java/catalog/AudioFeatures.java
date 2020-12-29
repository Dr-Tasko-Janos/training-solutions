package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioFeatures implements Feature{

    private int length;
    private String title;
    private List<String> performers = new ArrayList<>();
    private List<String> composer = new ArrayList<>();

    public AudioFeatures(String title, int length, List<String> performers) {
        if(Validators.isBlank(title)){
            throw new IllegalArgumentException("Title must not be empty!");
        }
        this.title = title;

        if(length <= 0){
            throw new IllegalArgumentException("Length must be greater than zero!");
        }
        this.length = length;

        if(Validators.isEmpty(performers)){
            throw new IllegalArgumentException("Performers must not be empty!");
        }
        this.performers = performers;
    }

    public AudioFeatures(String title, int length, List<String> performers, List<String> composer) {
        this(title, length, performers);

        if(Validators.isEmpty(composer)){
            throw new IllegalArgumentException("Composer must be not empty!");
        }
        this.composer = composer;
    }

    @Override
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();

        for (String performer : performers) {
            contributors.add(performer);
        }

        for (String composeR : composer) {
            contributors.add(composeR);
        }

       // Collections.sort(contributors);
        return List.copyOf(contributors);
    }
}

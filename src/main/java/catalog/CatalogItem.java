package catalog;

import java.util.*;

public class CatalogItem {

    private List<Feature> features = new ArrayList<>();
    private int price;
    private String registrationNumber;

    public CatalogItem(String registrationNumber, Feature... features) {
        this.registrationNumber = registrationNumber;
        this.features.addAll(Arrays.asList(features));
    }

    public int fullLengthAtOneItem() {
        int counter = 0;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                counter += ((AudioFeatures) feature).getLength();
            }
        }
        return counter;
    }

    public List<String> getContributors() {
        List<String> allContributors = new ArrayList<>();
        for (Feature feature : features) {
            allContributors.addAll(feature.getContributors());
        }
       // Collections.sort(allContributors);
        return List.copyOf(allContributors);
    }

    public List<String> getTitles() {
        List<String> allTitles = new ArrayList<>();
        for (Feature feature : features) {
            allTitles.add(feature.getTitle());
        }
        //Collections.sort(allTitles);
        return List.copyOf(allTitles);
    }

    public boolean hasAudioFeature() {
        boolean flag = false;
        for (Feature feature : features) {
            if (feature instanceof AudioFeatures) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean hasPrintedFeature() {
        boolean flag = false;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                flag = true;
            }
        }
        return flag;
    }

    public int numberOfPagesAtOneItem() {
        int counter = 0;
        for (Feature feature : features) {
            if (feature instanceof PrintedFeatures) {
                counter += ((PrintedFeatures) feature).getNumberOfPages();
            }
        }
        return counter;
    }

    public List<Feature> getFeatures() {
        return this.features;
    }

    public int getPrice() {
        return this.price;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}

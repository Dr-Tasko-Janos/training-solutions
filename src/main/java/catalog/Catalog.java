package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        this.catalogItems.add(catalogItem);
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasAudioFeature()) {
                audioLibraryItems.add(catalogItem);
            }
        }
        return List.copyOf(audioLibraryItems);
    }

    public int getFullLength() {
        int sumOfLength = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sumOfLength += catalogItem.fullLengthAtOneItem();
        }
        return sumOfLength;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedLibraryItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                printedLibraryItems.add(catalogItem);
            }
        }
        return List.copyOf(printedLibraryItems);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> foundElements = new ArrayList<>();
        for (CatalogItem item1 : catalogItems) {
            if (searchCriteria.hasTitle()) {
                for (String item2 : item1.getTitles()) {
                    if (searchCriteria.getTitle().equals(item2)) {
                        foundElements.add(item1);
                    }
                }

            } else if (!searchCriteria.hasTitle() && searchCriteria.hasContributor()) {
                for (String item2 : item1.getContributors()) {
                    if (searchCriteria.getContributor().equals(item2)) {
                        foundElements.add(item1);
                    }
                }
            }
        }
        return foundElements;
    }

    public int getAllPageNumber() {
        int sumOfPageNumber = 0;
        for (CatalogItem catalogItem : catalogItems) {
            catalogItem.numberOfPagesAtOneItem();
        }
        return sumOfPageNumber;
    }

    public double averagePageNumberOver(int referenceValue) {
        if(referenceValue <=0){
            throw new IllegalArgumentException("Number of pages must be a positive integer value!");
        }

        int sumOfPages = 0;
        int numberOfElements = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.numberOfPagesAtOneItem() > referenceValue) {
                sumOfPages += catalogItem.numberOfPagesAtOneItem();
                numberOfElements++;
            }
        }
        return (double) sumOfPages / (double) numberOfElements;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        for (int i = 0; i < catalogItems.size(); i++) {
            if (catalogItems.get(i).equals(registrationNumber)) {
                catalogItems.remove(i);
            }
        }
    }

}

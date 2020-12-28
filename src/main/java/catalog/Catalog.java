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

    public int getAllPageNumber() {
        int sumOfPageNumber = 0;
        for (CatalogItem catalogItem : catalogItems) {
            catalogItem.numberOfPagesAtOneItem();
        }
        return sumOfPageNumber;
    }

    public double averagePageNumberOver(int referenceValue) {
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

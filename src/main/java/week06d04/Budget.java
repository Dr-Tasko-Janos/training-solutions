package week06d04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Budget {

    private List<Item> itemList = new ArrayList<>();

        public Budget(List<Item> itemList){
        if(itemList != null && itemList instanceof List ){
            this.itemList = itemList;
        } else {
            throw new IllegalArgumentException("Expected a List of \"Item\" Elements at least with one element");
        }
    }

    public List<Item> getItemsByMonth(int month) {
        List<Item> selectedItems = new ArrayList<>();
        if (month <= 12 && month >= 1) {
            for (Item item : itemList) {
                if (item.getMonth() == month) {
                    System.out.println(item.getMonth() + " " + item.getName() + " " + item.getPrice());
                    selectedItems.add(item);
                }
            }
        }
        return selectedItems;
    }

    public static void main(String[] args) {

        Item item1 = new Item(120, 2, "productf");
        Item item2 = new Item(120, 2, "productF");
        Item item3 = new Item(130, 3, "productM");
        Item item4 = new Item(110, 1, "productJ");
        Item item5 = new Item(140, 4, "productA");
        Item item6 = new Item(110, 1, "productJ");
        Item item7 = new Item(180, 8, "productA");
        Item item8 = new Item(120, 1, "productJ");
        Item item9 = new Item(130, 3, "productM");
        Item item10 = new Item(140, 4, "productA");
        Item item11 = new Item(150, 5, "productM");
        Item item12 = new Item(220, 12, "productD");
        Item item13 = new Item(210, 11, "productN");
        Item item14 = new Item(110, 1, "productJ");
        Item item15 = new Item(220, 12, "productD");

        List<Item> myList = Arrays.asList(item1, item2, item3, item4, item5,item6, item7, item8, item9, item10, item11, item12, item13, item14, item15);

        Budget budget = new Budget(myList);

        System.out.println(budget.getItemsByMonth(12));
    }
}
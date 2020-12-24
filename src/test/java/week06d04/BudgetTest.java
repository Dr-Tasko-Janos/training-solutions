package week06d04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BudgetTest {

    @Test
    public void testForCaseJanuary01() {

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

        List<Item> myList = Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11, item12, item13, item14, item15);

        assertEquals(4, new Budget(myList).getItemsByMonth(1).size());
    }

    @Test
    public void testWithNullList() {
        List<Item> myNullList = null;
        assertEquals(4, new Budget(myNullList).getItemsByMonth(1).size());
    }

    @Test
    public void testWithEmptyList() {
        List<Item> myNullList = Arrays.asList();
        assertEquals(4, new Budget(myNullList).getItemsByMonth(1).size());
    }


}

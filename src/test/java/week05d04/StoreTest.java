package week05d04;


import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class StoreTest {
    Store store = new Store();


    @Test
    public void testCase0ForProduct0ToGiveAValidAndLaterDoubledElement() {
        Product myProduct0NotExpiredAndFirstItem = new Product("milk", 2021, 12, 26);
        assertEquals(true, store.addProduct(myProduct0NotExpiredAndFirstItem));
    }

    @Test
    public void testCase1ForProduct1() {
        Product myProduct1expired = new Product("milk", 2019, 1, 1);
        assertEquals(false, store.addProduct(myProduct1expired));
    }

    @Test
    public void testCaseForProduct2() {
        Product myProduct2NotExpired = new Product("juice", 2021, 12, 31);
        assertEquals(true, store.addProduct(myProduct2NotExpired));
    }

    @Test
    public void testCaseForProduct3() {
        Product myProduct3NotExpiredExist = new Product("milk", 2021, 1, 2);
        store.addProduct(myProduct3NotExpiredExist);
        Product myProduct4NotExpiredButExist = new Product("milk",2021,1,1);
        assertEquals(false, store.addProduct(myProduct4NotExpiredButExist));
    }
}
package week05d03;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListCounterTest {

    ListCounter testCase = new ListCounter();

    List<String> myList1 = Arrays.asList("Neque", "porro", "quisquam", "est", "qui",
            "dolorem", "ipsum", "quia", "dolor", "sit", "amet", "consectetur", "Adipisci", "velit");

    List<String> myList2 = Arrays.asList("Neque", "porro", "quisquam", "est", "qui",
            "dolorem", "ipsum", "quia", "dolor", "sit", "amet", "consectetur", "adipisci", "velit", "Anna");


    @Test
    public void testListCounter1(){
        assertEquals(2, testCase.listCounter(myList1));
    }


    @Test
    public void testListCounter2() {
        assertEquals(3, testCase.listCounter(myList2));
    }




/*
    //In case if last character matching is important too

    @Test
    public void testListCounter3() {

        assertEquals(3, testCase.listCounter(myList1)); //After counting manually
    }

    @Test
    public void testListCounter4() {
        assertEquals(4, testCase.listCounter(myList2));
    }*/
}


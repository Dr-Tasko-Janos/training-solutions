package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week07d01.MathAlogrithms.isPrime;

public class MathAlgorithmsTest {

    //Prime section
    @Test
    public void mathAlgorithmsTest2() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(2));
    }

    @Test

    public void mathAlgorithmsTest3() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(3));
    }

    @Test
    public void mathAlgorithmsTest7() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(7));
    }

    @Test
    public void mathAlgorithmsTest13() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(13));
    }

    @Test
    public void mathAlgorithmsTest10007() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(10007));
    }

    //Non-prime section
    @Test
    public void mathAlgorithmsTest4() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(false, isPrime(4));
    }

    @Test
    public void mathAlgorithmsTest16() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(false, isPrime(16));
    }

    @Test
    public void mathAlgorithmsTest10008() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(false, isPrime(10008));
    }

    //Exception section :-)

    @Test
    public void mathAlgorithmsTestMinus2() {
        MathAlogrithms mathAlogrithms = new MathAlogrithms();
        assertEquals(true, isPrime(-2));
    }
}

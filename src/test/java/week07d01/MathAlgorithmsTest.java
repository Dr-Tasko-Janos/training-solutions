package week07d01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week07d01.MathAlgorithms.isPrime;

public class MathAlgorithmsTest {

    //Prime section
    @Test
    public void mathAlgorithmsTest2() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(2));
    }

    @Test

    public void mathAlgorithmsTest3() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(3));
    }

    @Test
    public void mathAlgorithmsTest7() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(7));
    }

    @Test
    public void mathAlgorithmsTest13() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(13));
    }

    @Test
    public void mathAlgorithmsTest10007() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(10007));
    }

    //Non-prime section
    @Test
    public void mathAlgorithmsTest4() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(false, isPrime(4));
    }

    @Test
    public void mathAlgorithmsTest16() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(false, isPrime(16));
    }

    @Test
    public void mathAlgorithmsTest10008() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(false, isPrime(10008));
    }

    //Exception section :-)

    @Test
    public void mathAlgorithmsTestMinus2() {
        MathAlgorithms mathAlgorithms = new MathAlgorithms();
        assertEquals(true, isPrime(-2));
    }
}

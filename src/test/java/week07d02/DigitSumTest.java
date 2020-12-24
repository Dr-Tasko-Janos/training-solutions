package week07d02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static week07d02.DigitSum.sumOfDigits;


public class DigitSumTest {

    @Test

    public void DigitSumTest1236() {

        assertEquals(6, sumOfDigits(123));
    }

    @Test

    public void DigitSumTest1237() {
        assertEquals(13, sumOfDigits(1237));
    }

    @Test

    public void DigitSumTestForFalseCase() {
        assertEquals(5, sumOfDigits(123));
    }
}

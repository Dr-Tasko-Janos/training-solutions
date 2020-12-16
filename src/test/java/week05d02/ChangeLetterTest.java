package week05d02;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ChangeLetterTest {

    @Test
    public void changeLetterTester1(){
        ChangeLetter changeLetter = new ChangeLetter();
        assertThat ("H*ll*", equalTo(changeLetter.changeVowels("Hello")));
    }

    @Test
    public void changeLetterTester2(){
        ChangeLetter changeLetter = new ChangeLetter();
        assertThat ("H*ll*", equalTo(changeLetter.changeVowels("HEllO")));
    }
}

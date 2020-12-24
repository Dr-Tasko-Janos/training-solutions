package week06d03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordEraseTest {

    @Test
    public void testingeraseWordMethod() {

        WordEraser wordEraser = new WordEraser();

        assertEquals("körte barack szilva körte birsalma", wordEraser.eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
    }

    @Test
    public void testingeraseWordMethodForFalse() {

        WordEraser wordEraser = new WordEraser();

        assertEquals("körte barack alma szilva körte birsalma", wordEraser.eraseWord("alma körte barack alma szilva körte birsalma", "alma"));
    }
}

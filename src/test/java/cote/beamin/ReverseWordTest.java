package cote.beamin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ReverseWordTest {

    @Test
    public void testReversCharacter() {
        ReverseWord reverseWord = new ReverseWord();
        assertThat(reverseWord.revers('I')).isEqualTo('R');
        assertThat(reverseWord.revers('l')).isEqualTo('o');
    }

    @Test
    public void testReversWord() throws Exception {
        ReverseWord reverseWord = new ReverseWord();
        assertThat(reverseWord.reversWord("I love you")).isEqualTo("R olev blf");
        assertThat(reverseWord.reversWord("12345!@#$")).isEqualTo("12345!@#$");
    }

    @Test
    public void testReversWordException() {
        ReverseWord reverseWord = new ReverseWord();
        StringBuilder exceedString = new StringBuilder();
        for (int i = 0; i < 1001; i++) {
            exceedString.append("1");
        }
        assertThrows(Exception.class, () ->
            reverseWord.reversWord(exceedString.toString())
        );
    }
}
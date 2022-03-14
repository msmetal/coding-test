package cote.codility.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LongestPasswordTest {

    @Test
    public void getLongestPasswordEx1() {
        String[] passwordArray = {"test", "5", "a0A", "pass007", "?xy1"};
        LongestPassword lp = new LongestPassword();
        assertThat(lp.getLongestPassword(passwordArray)).isEqualTo("pass007");
    }

    @Test
    public void getLongestPasswordEx2() {
        String[] passwordArray = {"test", "?xy1"};
        LongestPassword lp = new LongestPassword();
        assertThat(lp.getLongestPassword(passwordArray)).isEmpty();
    }
}
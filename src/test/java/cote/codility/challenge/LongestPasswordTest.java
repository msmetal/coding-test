package cote.codility.challenge;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
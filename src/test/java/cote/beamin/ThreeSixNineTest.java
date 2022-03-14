package cote.beamin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ThreeSixNineTest {

    @Test
    public void testGetClapCount() {
        ThreeSixNine threeSixNine = new ThreeSixNine();

        int clapCount = threeSixNine.getClapCount(10001);
        assertThat(clapCount).isZero();

        clapCount = threeSixNine.getClapCount(13);
        assertThat(clapCount).isEqualTo(4);

        clapCount = threeSixNine.getClapCount(33);
        assertThat(clapCount).isEqualTo(14);

    }


}
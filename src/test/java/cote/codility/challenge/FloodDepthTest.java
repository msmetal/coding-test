package cote.codility.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FloodDepthTest {

    @Test
    public void testMaxFloodDepthEx1() {
        int[] mountain = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
        FloodDepth fd = new FloodDepth();
        int maxDepth = fd.maxFloodDepth(mountain);
        assertThat(maxDepth).isEqualTo(2);
    }

    @Test
    public void testMaxFloodDepthEx2() {
        int[] mountain = {5, 8};
        FloodDepth fd = new FloodDepth();
        int maxDepth = fd.maxFloodDepth(mountain);
        assertThat(maxDepth).isZero();
    }

    @Test
    public void testMaxFloodDepthEx3() {
        int[] mountain = {6, 5, 7, 8, 6, 2, 4, 6, 5, 7, 8, 6, 2, 4};
        FloodDepth fd = new FloodDepth();
        int maxDepth = fd.maxFloodDepth(mountain);
        assertThat(maxDepth).isEqualTo(6);
    }
}
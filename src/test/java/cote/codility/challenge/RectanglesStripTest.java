package cote.codility.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RectanglesStripTest {

    @Test
    public void testManyRectangularStreams() {

        RectanglesStrip silver2020 = new RectanglesStrip();
        int test1 = silver2020.getManyRectangles(new int[]{2, 3, 2, 3, 5}, new int[]{3, 4, 2, 4, 2});
        int test2 = silver2020.getManyRectangles(new int[]{2, 3, 1, 3}, new int[]{2, 3, 1, 3});
        int test3 = silver2020.getManyRectangles(new int[]{2, 10, 4, 1, 4}, new int[]{4, 1, 2, 2, 5});

        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);

        assertThat(test1).isEqualTo(3);
        assertThat(test2).isEqualTo(2);
        assertThat(test3).isEqualTo(3);
    }
}
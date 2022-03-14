package cote.beamin;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MakeRectangleTest {

    @Test
    public void test1() throws Exception {
        int[][] v = {{1, 4}, {3, 4}, {3, 10}};
        MakeRectangle rectangle = new MakeRectangle();
        int[] result = rectangle.getLastPoint(v);
        assertThat(result[0]).isEqualTo(1);
        assertThat(result[1]).isEqualTo(10);
    }

    @Test
    public void test2() throws Exception {
        int[][] v = {{1, 1}, {2, 2}, {1, 2}};
        MakeRectangle rectangle = new MakeRectangle();
        int[] result = rectangle.getLastPoint(v);
        assertThat(result[0]).isEqualTo(2);
        assertThat(result[1]).isEqualTo(1);
    }

    @Test
    public void testInvalidInputData1() {
        int[][] v = {{1, 4}, {3, 4}, {2, 10}};
        MakeRectangle rectangle = new MakeRectangle();
        assertThrows(Exception.class, () ->
            rectangle.getLastPoint(v)
        );
    }

    @Test
    public void testInvalidInputData2() {
        int[][] v = {{1, 10}, {3, 4}, {3, 4}};
        MakeRectangle rectangle = new MakeRectangle();
        assertThrows(Exception.class, () ->
            rectangle.getLastPoint(v)
        );
    }
}
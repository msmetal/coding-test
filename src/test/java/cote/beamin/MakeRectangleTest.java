package cote.beamin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test(expected = Exception.class)
    public void testInvalidInputData1() throws Exception {
        int[][] v = {{1, 4}, {3, 4}, {2, 10}};
        MakeRectangle rectangle = new MakeRectangle();
        rectangle.getLastPoint(v);
    }

    @Test(expected = Exception.class)
    public void testInvalidInputData2() throws Exception {
        int[][] v = {{1, 10}, {3, 4}, {3, 4}};
        MakeRectangle rectangle = new MakeRectangle();
        rectangle.getLastPoint(v);
    }


}
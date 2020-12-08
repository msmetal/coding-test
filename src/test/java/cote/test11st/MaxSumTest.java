package cote.test11st;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxSumTest {

    @Test
    public void testFindMaxSum() {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        MaxSum maxSum = new MaxSum();
        assertThat(maxSum.findMaxSum(list)).isEqualTo(20);
        assertThat(maxSum.findMaxSum2(list)).isEqualTo(20);
    }
}
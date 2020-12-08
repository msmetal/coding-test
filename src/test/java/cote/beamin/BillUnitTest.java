package cote.beamin;

import org.junit.Test;
import java.util.Arrays;


public class BillUnitTest {

    @Test
    public void testSplitMoney() {
        BillUnit billUnit = new BillUnit();

        int[] result1 = billUnit.splitMoney(50237);
        System.out.println(Arrays.toString(result1));

        int[] result2 = billUnit.splitMoney(15000);
        System.out.println(Arrays.toString(result2));

    }
}
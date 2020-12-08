package cote.codility.lesson16;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TieRopesTest {

    @Test
    public void testAdjacentRopesCount1() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(4, new int[]{1, 2, 3, 4, 1, 1, 3});
        assertThat(tieCount).isEqualTo(3);
    }

    @Test
    public void testAdjacentRopesCount2() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(50, new int[]{5, 9, 12, 15, 17, 20, 24, 35, 37});
        assertThat(tieCount).isEqualTo(4);
    }

    @Test
    public void testAdjacentRopesCount3() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(1, new int[]{1});
        assertThat(tieCount).isEqualTo(1);
    }

    @Test
    public void testAdjacentRopesCount4() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(1, new int[]{2});
        assertThat(tieCount).isEqualTo(1);
    }

    @Test
    public void testAdjacentRopesCount5() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(2, new int[]{1});
        assertThat(tieCount).isZero();
    }

    @Test
    public void testAdjacentRopesCount6() {
        TieRopes1 tieRopes = new TieRopes1();
        int tieCount = tieRopes.adjacentRopesCount(3, new int[]{1, 1});
        assertThat(tieCount).isZero();
    }

}
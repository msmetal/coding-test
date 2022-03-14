package cote.codility.challenge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class CoverBuildingsTest {

    @Test
    public void test() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {12, 5, 2, 20, 5, 2};
        System.out.println(coverBuildings.getCoverSize(buildings));
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(80 + 10);
    }

    @Test
    public void test1() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {12, 5, 17, 20, 15, 6, 7, 6};
        System.out.println(coverBuildings.getCoverSize(buildings));
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(100 + 21);
    }

    @Test
    public void test2() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {3, 1, 4};
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(6 + 4);
    }

    @Test
    public void test3() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {5, 3, 2, 4};
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(5 + 12);
    }

    @Test
    public void test4() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {5, 3, 5, 2, 1};
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(15 + 4);
    }

    @Test
    public void test5() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {7, 7, 3, 7, 7};
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(35);
    }

    @Test
    public void test6() {
        CoverBuildings coverBuildings = new CoverBuildings();
        int[] buildings = {1, 1, 7, 6, 6, 6};
        assertThat(coverBuildings.getCoverSize(buildings)).isEqualTo(2 + 28);
    }

}
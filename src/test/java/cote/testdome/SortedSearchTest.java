package cote.testdome;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SortedSearchTest {

    @Test
    public void countNumbers() {
        assertThat(SortedSearch.countNumbers(new int[]{1, 3, 4, 5, 7}, 5)).isEqualTo(3);
        assertThat(SortedSearch.countNumbers(new int[]{1, 3, 4, 5, 7}, 3)).isEqualTo(1);
        assertThat(SortedSearch.countNumbers(new int[]{1, 3, 4, 5, 7}, 1)).isZero();
        assertThat(SortedSearch.countNumbers(new int[]{1, 3, 4, 5, 7}, 8)).isEqualTo(5);
    }
}
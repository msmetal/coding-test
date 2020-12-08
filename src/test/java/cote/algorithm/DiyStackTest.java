package cote.algorithm;

import org.junit.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class DiyStackTest {

    @Test
    public void test() {
        DiyStack<Integer> s = new DiyStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        assertThat(s.pop()).isEqualTo(4);
        assertThat(s.pop()).isEqualTo(3);
        assertThat(s.peek()).isEqualTo(2);
        assertThat(s.pop()).isEqualTo(2);
        assertThat(s.isEmpty()).isFalse();
        assertThat(s.pop()).isEqualTo(1);
        assertThat(s.isEmpty()).isTrue();
    }

    @Test
    public void javaStack() {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        assertThat(s.pop()).isEqualTo(4);
        assertThat(s.pop()).isEqualTo(3);
        assertThat(s.peek()).isEqualTo(2);
        assertThat(s.pop()).isEqualTo(2);
        assertThat(s.isEmpty()).isFalse();
        assertThat(s.pop()).isEqualTo(1);
        assertThat(s.isEmpty()).isTrue();
    }
}
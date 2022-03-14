package cote.algorithm;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void test() {
        DiyQueue<Integer> q = new DiyQueue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        assertThat(q.remove()).isEqualTo(1);
        assertThat(q.remove()).isEqualTo(2);
        assertThat(q.peek()).isEqualTo(3);
        assertThat(q.remove()).isEqualTo(3);
        assertThat(q.isEmpty()).isFalse();
        assertThat(q.remove()).isEqualTo(4);
        assertThat(q.isEmpty()).isTrue();
    }

    @Test
    public void javaQueue() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        assertThat(q.remove()).isEqualTo(1);
        assertThat(q.poll()).isEqualTo(2);
        assertThat(q.peek()).isEqualTo(3);
        assertThat(q.isEmpty()).isFalse();
        assertThat(q.poll()).isEqualTo(3);
        assertThat(q.poll()).isEqualTo(4);
        assertThat(q.isEmpty()).isTrue();
        assertThat(q.poll()).isNull();
    }
}
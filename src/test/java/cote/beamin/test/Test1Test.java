package cote.beamin.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test1Test {

    @Test
    public void solution1() {
        // Given U = 3, L = 2, C = [2, 1, 1, 0, 1], => 11001,10100
        // upper = [1, 1, 0, 0, 1]
        // lower = [1, 0, 1, 0, 0]

        Test1 test1 = new Test1();
        String result =  test1.solution(3, 2, new int[]{2, 1, 1, 0, 1});
        System.out.println(result);
    }

    @Test
    public void solution2() {
        Test1 test1 = new Test1();
        String result =  test1.solution(2, 3, new int[]{0, 0, 1, 1, 2});
        System.out.println(result);
    }

    @Test
    public void solution3() {
        Test1 test1 = new Test1();
        String result =  test1.solution(2, 2, new int[]{2, 0, 2, 0});
        System.out.println(result);
    }
}
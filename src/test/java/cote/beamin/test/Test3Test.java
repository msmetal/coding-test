package cote.beamin.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test3Test {

    @Test
    public void solution() {
        Test3 test3 = new Test3();
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 2;
        A[2] = -2;
        A[3] = 5;
        A[4] = -3;
        System.out.println(test3.solution(A));
    }
}
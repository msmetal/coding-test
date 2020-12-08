package cote.beamin.test;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test4Test {

    @Test
    public void test1() {
        Test4 test4 = new Test4();
        int result = test4.solution(new int[]{1,3,2,1}, new int[]{4,2,5,3,2});
        System.out.println(result);
    }

    @Test
    public void test2() {
        Test4 test4 = new Test4();
        int result = test4.solution(new int[]{2,1}, new int[]{3,3});
        System.out.println(result);
    }

    @Test
    public void test3() {
        Test4 test4 = new Test4();
        int result = test4.solution(new int[]{3, 5, 1,1}, new int[]{2,5,4});
        System.out.println(result);
    }

    @Test
    public void test4() {
        Test4 test4 = new Test4();
        int result = test4.solution(new int[]{2,5,4}, new int[]{3, 5, 1,1});
        System.out.println(result);
    }

    @Test
    public void test5() {
        Test4 test4 = new Test4();
        int result = test4.solution(new int[]{3,2}, new int[]{1,1,2,5,3});
        System.out.println(result);
    }


}
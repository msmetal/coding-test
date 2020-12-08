package cote.beamin.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 30분
public class Test3 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A == null || A.length > 100000) {
            return 0;
        }

        List<Integer> sortedList = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());

        int i = 0;
        int j = sortedList.size() - 1;

        while (i < j) {
            int min = sortedList.get(i);
            int max = sortedList.get(j);
            if (max == Math.abs(min)) {
                return max;
            }
            if (Math.abs(min) > max) {
                i++;
            } else {
                j--;
            }
        }

        return 0;
    }
}

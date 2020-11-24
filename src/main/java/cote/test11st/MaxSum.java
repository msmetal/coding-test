package cote.test11st;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
가장 큰수 두개 합 구하기
 */

public class MaxSum {

    public int findMaxSum(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() <= 2) {
            return list.get(0) + list.get(1);
        }
        List<Integer> sorted = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return sorted.get(0) + sorted.get(1);
    }

    public int findMaxSum2(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        if (list.size() <= 2) {
            return list.get(0) + list.get(1);
        }

        int top1 = 0;
        int top2 = 0;
        for (Integer item : list) {
            if (top1 < item) {
                top2 = top1;
                top1 = item;
            } else {
                if (top2 < item) {
                    top2 = item;
                }
            }
        }
        return top1 + top2;
    }
}
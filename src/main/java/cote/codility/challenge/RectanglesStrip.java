package cote.codility.challenge;

import java.util.HashMap;
import java.util.Map;

/*
There are N rectangles numbered from 0 to N-1. The K-th rectangle has size A[K] × B[K].

We want to arrange as many rectangles as possible into a strip. The rectangles can be arranged into a strip if they all share a side of the same length (which becomes the height of the strip). Note that rectangles can be rotated.

Write a function:

class Solution { public int solution(int[] A, int[] B); }

that, given two arrays A and B of N integers each, returns the maximum number of rectangles that can be arranged into a strip.

Examples:

1. Given A = [2, 3, 2, 3, 5] and B = [3, 4, 2, 4, 2], the function should return 3. Choosing the 0th, 2nd and 4th rectangles we can obtain the following strip of height 2 (note that the 0th rectangle was rotated):

(3 × 2), (2 × 2), (5 × 2)

We can also choose the 0th, 1st and 3rd rectangles to obtain a strip of height 3. Here we have rotated 1st and 3rd rectangles:

(2 × 3), (4 × 3), (4 × 3)

2. Given A = [2, 3, 1, 3] and B = [2, 3, 1, 3], the function should return 2. We can choose the 1st and 3rd rectangles:

(3 × 3), (3 × 3)

3. Given A = [2, 10, 4, 1, 4] and B = [4, 1, 2, 2, 5], the function should return 3. We can choose the 0th, 2nd and 4th rectangles to obtain a strip of height 4:

(2 × 4), (2 × 4), (5 × 4)

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
arrays A and B both consist of N integers;
each element of arrays A, B is an integer within the range [1..1,000,000,000].
 */

public class RectanglesStrip {

    public int getManyRectangles(int[] arrayA, int[] arrayB) {

        if (arrayA.length != arrayB.length) {
            return 0;
        }
        if (arrayA.length > 100000) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i = 0; i < arrayA.length; i++) {
            countToMap(countMap, arrayA, arrayB, arrayA[i]);
            countToMap(countMap, arrayA, arrayB, arrayB[i]);
        }

        return countMap.values().stream().max(Integer::compareTo).orElse(0);
    }

    private void countToMap(Map<Integer, Integer> countMap, int[] arrayA, int[] arrayB, int compare) {
        if (!countMap.containsKey(compare)) {
            countMap.put(compare, sameSideLengthCount(arrayA, arrayB, compare));
        }
    }

    private int sameSideLengthCount(int[] arrayA, int[] arrayB, int compare) {
        int count = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] == compare || arrayB[i] == compare) {
                count++;
            }
        }
        return count;
    }
}

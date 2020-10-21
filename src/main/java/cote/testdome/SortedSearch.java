package cote.testdome;

/*
이진탐색을 사용해야 100% 통과 됨
 */

/*
Implement function countNumbers that accepts a sorted array of unique integers and, efficiently with respect to time used, counts the number of array elements that are less than the parameter lessThan.

For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int start = 0;
        int end = sortedArray.length - 1;
        int index = -1;

        if (sortedArray[0] > lessThan) {
            return 0;
        }
        if (sortedArray[sortedArray.length - 1] < lessThan) {
            return sortedArray.length;
        }

        while (start < end) {
            int half = (start + end) / 2;
            if (sortedArray[half] < lessThan) {
                index = half;
                if (start == half) {
                    break;
                } else {
                    start = half;
                }
            } else {
                end = half;
            }
        }

        return index + 1;
    }
}


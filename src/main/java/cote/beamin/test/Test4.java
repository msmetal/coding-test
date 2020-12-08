package cote.beamin.test;

import java.util.Arrays;

// 50분
public class Test4 {

    int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            if (i < m - 1 && B[i] < A[k])
            {   i++;  k--;
            } else if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }

}

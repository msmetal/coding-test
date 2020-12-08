package cote.codility.lesson16;

/*
There are N ropes numbered from 0 to N − 1, whose lengths are given in an array A, lying on the floor in a line. For each I (0 ≤ I < N), the length of rope I on the line is A[I].

We say that two ropes I and I + 1 are adjacent. Two adjacent ropes can be tied together with a knot, and the length of the tied rope is the sum of lengths of both ropes. The resulting new rope can then be tied again.

For a given integer K, the goal is to tie the ropes in such a way that the number of ropes whose length is greater than or equal to K is maximal.

For example, consider K = 4 and array A such that:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 1
    A[5] = 1
    A[6] = 3
The ropes are shown in the figure below.



We can tie:

rope 1 with rope 2 to produce a rope of length A[1] + A[2] = 5;
rope 4 with rope 5 with rope 6 to produce a rope of length A[4] + A[5] + A[6] = 5.
After that, there will be three ropes whose lengths are greater than or equal to K = 4. It is not possible to produce four such ropes.

Write a function:

class Solution { public int solution(int K, int[] A); }

that, given an integer K and a non-empty array A of N integers, returns the maximum number of ropes of length greater than or equal to K that can be created.

For example, given K = 4 and array A such that:

    A[0] = 1
    A[1] = 2
    A[2] = 3
    A[3] = 4
    A[4] = 1
    A[5] = 1
    A[6] = 3
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
K is an integer within the range [1..1,000,000,000];
each element of array A is an integer within the range [1..1,000,000,000].
 */

/*
순서대로 최대 로프 구하기
 */

public class TieRopes2 {

    public int adjacentRopesCount(int length, int[] ropes) {
        if (ropes == null || ropes.length > 100000) {
            return 0;
        }
        TiedRopes2 maxRope = new TiedRopes2(length);
        for (int i = 0; i < ropes.length; i++) {
            TiedRopes2 tiedRopes = new TiedRopes2(length);
            tiedRopes.tie(ropes[i]);
            if (tiedRopes.getSumLength() < length && ropes.length > 2) {
                for (int j = i + 1; j < ropes.length; j++) {
                    if (tiedRopes.wantRope()) {
                        tiedRopes.tie(ropes[j]);
                    }
                }
            }
            if (maxRope.getTieCount() < tiedRopes.getTieCount()) {
                maxRope = tiedRopes;
            }
        }
        return maxRope.getTieCount();
    }

}

class TiedRopes2 {

    private int wantLength;
    private int sumLength = 0;
    private int tieCount = 0;

    TiedRopes2(int wantLength) {
        this.wantLength = wantLength;
    }

    public void tie(int rope) {
        sumLength += rope;
        tieCount++;
    }

    public int getSumLength() {
        return sumLength;
    }

    public int getTieCount() {
        if (wantLength > sumLength) {
            return 0;
        } else {
            return tieCount;
        }
    }

    public boolean wantRope() {
        return sumLength < wantLength;
    }
}

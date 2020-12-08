package cote.beamin.test;

import java.util.Arrays;

// 47분
public class Test1 {

    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final int MAX_LENGTH = 100000;

    public String solution(int U, int L, int[] C) {

        if (U > MAX_LENGTH || L > MAX_LENGTH) {
            return IMPOSSIBLE;
        }
        if (C == null || C.length > MAX_LENGTH) {
            return IMPOSSIBLE;
        }

        // Given U = 3, L = 2, C = [2, 1, 1, 0, 1], => 11001,10100
        // upper = [1, 1, 0, 0, 1]
        // lower = [1, 0, 1, 0, 0]

        Board board = new Board(C);

        for (int i = 0; i < C.length; i++) {
            if (C[i] == 2) {
                board.both(i);
            } else if (C[i] == 0) {
                board.notBoth(i);
            } else {
                if (board.getUpperCount() < U) {
                    board.countUpper(i);
                } else {
                    board.countLower(i);
                }
            }
        }

        if (board.getUpperCount() != U || board.getLowerCount() != L) {
            return IMPOSSIBLE;
        }

        return board.printUpper() + "," + board.printLower();
    }
}

class Board {
    private int[] upper;
    private int[] lower;
    private int upperCount = 0;
    private int lowerCount = 0;

    Board(int[] C) {
        this.upper = new int[C.length];
        this.lower = new int[C.length];
    }

    public void both(int i) {
        upper[i] = 1;
        lower[i] = 1;
        upperCount++;
        lowerCount++;
    }

    public void notBoth(int i) {
        upper[i] = 0;
        lower[i] = 0;
    }

    public void countUpper(int i) {
        upper[i] = 1;
        upperCount++;
    }

    public void countLower(int i) {
        lower[i] = 1;
        lowerCount++;
    }

    public int getUpperCount() {
        return upperCount;
    }

    public int getLowerCount() {
        return lowerCount;
    }

    public String printUpper() {
        return Arrays.toString(upper).replaceAll("[^0-9]","");
    }

    public String printLower() {
        return Arrays.toString(lower).replaceAll("[^0-9]","");
    }
}

package cote.beamin;
/*
3,6,9 게임
누적 박수 횟수 구하기
 */

import java.util.function.IntPredicate;

public class ThreeSixNine {

    IntPredicate isClap = i -> i == 3 || i == 6 || i == 9;

    public int getClapCount(int input) {
        if (input < 1 || input > 10000) {
            return 0;
        }

        int clapCount = 0;
        for (int i = 1; i <= input; i++) {
            int number = i;
            while (number != 0) {
                int singleDigit = number % 10;
                if (isClap.test(singleDigit)) {
                    clapCount++;
                }
                number = number / 10;
            }
        }

        return clapCount;
    }
}

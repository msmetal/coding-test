package cote.beamin;
/*
직사각형을 만드는데 필요한 마지막 좌표 구하기
 */
public class MakeRectangle {

    public int[] getLastPoint(int[][] rectangle) throws Exception {
        int resultX = 0;
        int resultY = 0;
        int notSame = 0;
        int same = 0;

        for (int[] point : rectangle) {
            int x = point[0];
            int y = point[1];
            int xCount = 0;
            int yCount = 0;

            for (int[] compare : rectangle) {
                if (x == compare[0]) {
                    xCount++;
                }
                if (y == compare[1]) {
                    yCount++;
                }
            }

            if (xCount == 1) {
                resultX = x;
                notSame++;
            }

            if (yCount == 1) {
                resultY = y;
                notSame++;
            }

            if (xCount == 2 || yCount == 2) {
                same++;
            }
        }
        System.out.println("validCount1=" + notSame + ", validCount2=" + same);

        if (notSame != 2 || same != 3) {
            throw new Exception("Invalid Input Data");
        }

        return new int[]{resultX, resultY};
    }
}

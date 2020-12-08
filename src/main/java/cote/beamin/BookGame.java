package cote.beamin;

import java.util.Random;

/*
포비와 크롱의 책 따먹기
펼쳐서 나온 왼쪽페이지와 오른쪽페이지 번호로 점수를 매겨 승자 구하기
1. 점수 계산 : 왼쪽 또는 오른쪽 페이지 번호의 각 자리 수를 더하거나 곱해서 나온 큰수
2. 첫페이지와 마지막페이지는 제외.
 */

public class BookGame {

    public static void main(String[] args) {
        Book pobi = new Book();
        Book crong = new Book();

        System.out.println(getWinner(pobi, crong));
    }

    public static int getWinner(Book pobi, Book crong) {
        System.out.println("pobi:[" + pobi.leftPage + "," + pobi.rightPage + "]");
        System.out.println("crong:[" + crong.leftPage + "," + crong.rightPage + "]");
        System.out.println("pobi:[" + pobi.getLeftScore() + "," + pobi.getRightScore() + "]");
        System.out.println("crong:[" + crong.getLeftScore() + "," + crong.getRightScore() + "]");
        if (pobi.getScore() > crong.getScore()) {
            System.out.println("winner is pobi");
            return 1;
        } else if (pobi.getScore() < crong.getScore()) {
            System.out.println("winner is crong");
            return -1;
        } else {
            System.out.println("draw");
            return 0;
        }
    }

    private static class Book {
        private int leftPage;
        private int rightPage;

        Book() {
            Random random = new Random();
            int randomPage = random.nextInt(198) + 2;
            this.leftPage = randomPage * 2 - 1;
            this.rightPage = randomPage * 2;
        }

        private int getLeftScore() {
            return Math.max(sum(this.leftPage), multiply(this.leftPage));
        }

        private int getRightScore() {
            return Math.max(sum(this.rightPage), multiply(this.rightPage));
        }

        int getScore() {
            return Math.max(getLeftScore(), getRightScore());
        }

        private int sum(int number) {
            int sum = 0;
            while (number != 0) {
                sum += (number % 10);
                number = number / 10;
            }
            return sum;
        }

        private int multiply(int number) {
            int sum = 1;
            while (number != 0) {
                sum *= (number % 10);
                number = number / 10;
            }
            return sum;
        }
    }
}

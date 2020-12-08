package cote.beamin;

/*
입력 된 금액 돈 단위 수 계산
5만원, 만원, 5천원, 천원, 5백원, 백원, 5십원, 십원, 1원

50237 = [1, 0, 0, 0, 0, 2, 0, 3, 7]
15000 = [0, 1, 1, 0, 0, 0, 0, 0, 0]

 */

public class BillUnit {

    public int[] splitMoney(int money) {
        int[] wallet = new int[9];
        int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < unit.length; i++) {
            wallet[i] = money / unit[i];
            money = money % unit[i];
        }

        return wallet;
    }

}

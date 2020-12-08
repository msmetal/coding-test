package cote.beamin;
/*
중복 문자 제거
input : browoanoommnaon
중복제거 > browoannaon
중복제거 > browoaaon
중복제거 > browoon
output : brown
 */
public class Cryptogram {

    public String encrypt(String cryptogram) {
        StringBuilder result = new StringBuilder();
        result.append(cryptogram.charAt(0));
        boolean isDuplicated = false;

        for (int i = 1; i < cryptogram.length(); i++) {
            char indexChar = cryptogram.charAt(i);
            char prevChar = cryptogram.charAt(i - 1);
            if (indexChar == prevChar) {
                result.deleteCharAt(result.length() - 1);
                isDuplicated = true;
            } else {
                result.append(indexChar);
            }
        }

        System.out.println("crypt : " + result);

        if (isDuplicated) {
            return encrypt(result.toString());
        } else {
            return result.toString();
        }
    }
}

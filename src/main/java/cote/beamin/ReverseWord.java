package cote.beamin;

import java.util.function.Predicate;
/*
알파벳 문자만 거꾸로 변경 a -> z, A -> Z, z -> a, Z -> A
 */

public class ReverseWord {

    public String reversWord(String word) throws Exception {
        if (word == null || word.length() > 1000) {
            throw new Exception("invalid input word");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word.toCharArray()) {
            stringBuilder.append(revers(c));
        }
        return stringBuilder.toString();
    }

    public char revers(char in) {
        Predicate<Character> isUpper = c -> c >= 'A' && c <= 'Z';
        Predicate<Character> isLower = c -> c >= 'a' && c <= 'z';

        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';

        if (isUpper.test(in)) {
            return (char) (Z - (in - A));
        } else if (isLower.test(in)) {
            return (char) (z - (in - a));
        } else {
            return in;
        }
    }
}

package cote.codility.challenge;

/*
 You would like to set a password for a bank account. However, there are three restrictions on the format of the password:

 it has to contain only alphanumerical characters (a−z, A−Z, 0−9);
 there should be an even number of letters;
 there should be an odd number of digits.
 You are given a string S consisting of N characters. String S can be divided into words by splitting it at, and removing, the spaces. The goal is to choose the longest word that is a valid password. You can assume that if there are K spaces in string S then there are exactly K + 1 words.

 For example, given "test 5 a0A pass007 ?xy1", there are five words and three of them are valid passwords: "5", "a0A" and "pass007". Thus the longest password is "pass007" and its length is 7. Note that neither "test" nor "?xy1" is a valid password, because "?" is not an alphanumerical character and "test" contains an even number of digits (zero).

 Write a function:

 class Solution { public int solution(String S); }

 that, given a non-empty string S consisting of N characters, returns the length of the longest word from the string that is a valid password. If there is no such word, your function should return −1.

 For example, given S = "test 5 a0A pass007 ?xy1", your function should return 7, as explained above.

 Assume that:

 N is an integer within the range [1..200];
 string S consists only of printable ASCII characters and spaces.
 In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 */

public class LongestPassword {

    public String getLongestPassword(String[] passwordArray) {
        String longestPassword = "";

        for (String password : passwordArray) {
            if (validPassword(password)) {
                if (longestPassword.length() < password.length()) {
                    longestPassword = password;
                }
            }
        }
        return longestPassword;
    }

    private boolean validPassword(String password) {
        if (!password.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }

        char[] chars = password.toCharArray();
        int abcCount = 0;
        for (char c : chars) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                abcCount++;
            }
        }
        if (abcCount % 2 == 1) {
            return false;
        }
        return password.length() % 2 != 0;
    }
}


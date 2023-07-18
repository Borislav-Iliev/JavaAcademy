package LeetCode;

public class _13_RomanToInteger {

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII,
    which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
    IIII.Instead, the number four is written as IV. Because the one is before the five we subtract it making
    four. The same principle applies to the number nine, which is written as IX. There are six instances where
    subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
     */

    public int romanToInt(String s) {
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            char nextCharacter;

            switch (currentCharacter) {
                case 'I' -> {
                    if (i == s.length() - 1) {
                        number += 1;
                    } else {
                        nextCharacter = s.charAt(i + 1);
                        if (nextCharacter == 'V') {
                            number += 4;
                            i++;
                        } else if (nextCharacter == 'X') {
                            number += 9;
                            i++;
                        } else {
                            number += 1;
                        }
                    }
                }
                case 'V' -> number += 5;
                case 'X' -> {
                    if (i == s.length() - 1) {
                        number += 10;
                    } else {
                        nextCharacter = s.charAt(i + 1);
                        if (nextCharacter == 'L') {
                            number += 40;
                            i++;
                        } else if (nextCharacter == 'C') {
                            number += 90;
                            i++;
                        } else {
                            number += 10;
                        }
                    }
                }
                case 'L' -> number += 50;
                case 'C' -> {
                    if (i == s.length() - 1) {
                        number += 100;
                    } else {
                        nextCharacter = s.charAt(i + 1);
                        if (nextCharacter == 'D') {
                            number += 400;
                            i++;
                        } else if (nextCharacter == 'M') {
                            number += 900;
                            i++;
                        } else {
                            number += 100;
                        }
                    }
                }
                case 'D' -> number += 500;
                case 'M' -> number += 1000;
            }
        }
        return number;
    }
}

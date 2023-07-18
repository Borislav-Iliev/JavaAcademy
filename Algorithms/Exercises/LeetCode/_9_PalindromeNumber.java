package LeetCode;

public class _9_PalindromeNumber {

    /*
    Given an integer x, return true if x is a palindrome, and false otherwise.
     */

    public static boolean isPalindrome(int x) {
        String xAsStringReversed = new StringBuilder(String.valueOf(x)).reverse().toString();

        return xAsStringReversed.equals(String.valueOf(x));
    }
}

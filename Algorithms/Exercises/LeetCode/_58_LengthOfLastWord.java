package LeetCode;

public class _58_LengthOfLastWord {

    /*
    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal substring consisting of non-space characters only.
     */

    public int lengthOfLastWord(String s) {
        String[] tokens = s.split("\\s+");
        return tokens[tokens.length - 1].length();
    }
}

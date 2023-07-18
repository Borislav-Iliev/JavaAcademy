package LeetCode;

import java.util.Arrays;

public class _14_LongestCommonPrefix {

    /*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".
     */

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < firstWord.length(); i++) {
            char firstWordCharacter = firstWord.charAt(i);
            char lastWordCharacter = lastWord.charAt(i);

            if (firstWordCharacter != lastWordCharacter) {
                break;
            }

            sb.append(firstWordCharacter);
        }

        return sb.toString();
    }
}

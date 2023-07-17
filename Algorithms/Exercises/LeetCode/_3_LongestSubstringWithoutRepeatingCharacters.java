package LeetCode;

public class _3_LongestSubstringWithoutRepeatingCharacters {

    /*
    Given a string s, find the length of the longest substring without repeating characters.
     */

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sb = new StringBuilder();

        int biggestLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentCharacter = s.charAt(i);
            sb.append(currentCharacter);

            for (int j = i + 1; j < s.length(); j++) {
                char nextCharacter = s.charAt(j);

                if (sb.toString().contains(String.valueOf(nextCharacter))) {
                    break;
                }
                sb.append(nextCharacter);
            }

            if (biggestLength < sb.length()) {
                biggestLength = sb.length();
            }
            sb.setLength(0);
        }

        return biggestLength;
    }
}

package LeetCode;

public class _1528_ShuffleString {

    public static String restoreString(String s, int[] indices) {
        StringBuilder shuffle = new StringBuilder();
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            chars[indices[i]] = s.charAt(i);
        }

        return shuffle.append(chars).toString();
    }
}

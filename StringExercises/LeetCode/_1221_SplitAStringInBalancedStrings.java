package LeetCode;

public class _1221_SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int count = 0;
        int r = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char element = s.charAt(i);

            if (element == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                count++;
                l = 0;
                r = 0;
            }
        }
        return count;
    }
}

package LeetCode;

public class _771_JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char element = stones.charAt(i);
            if (jewels.contains(String.valueOf(element))) {
                count++;
            }
        }
        return count;
    }
}

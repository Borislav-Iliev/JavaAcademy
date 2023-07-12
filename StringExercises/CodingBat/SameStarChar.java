package CodingBat;

public class SameStarChar {

    public boolean sameStarChar(String str) {
        boolean isSame = true;

        for (int i = 1; i < str.length() - 1; i++) {
            char element = str.charAt(i);

            if (element == '*') {
                isSame = str.charAt(i - 1) == str.charAt(i + 1);
            }
        }

        return isSame;
    }
}

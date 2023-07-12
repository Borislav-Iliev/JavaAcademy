package CodingBat;

public class CountCode {

    public static int countCode(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 4).matches("[co]+.[e]")) {
                count++;
            }
        }

        return count;
    }
}

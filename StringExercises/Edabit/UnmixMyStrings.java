package Edabit;

public class UnmixMyStrings {

    public static String unmix(String str) {
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length - 1; i += 2) {
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
        }

        return String.valueOf(chars);
    }
}

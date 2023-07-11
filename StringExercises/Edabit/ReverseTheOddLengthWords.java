package Edabit;

public class ReverseTheOddLengthWords {

    public static String reverseOdd(String str) {
        String[] tokens = str.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];

            if (word.length() % 2 != 0) {
                tokens[i] = new StringBuilder(word).reverse().toString();
            }
        }

        return String.join(" ", tokens);
    }
}

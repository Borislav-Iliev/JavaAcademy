package CodingBat;

public class WordEnds {

    public static String wordEnds(String str, String word) {
        StringBuilder sb = new StringBuilder();

        int strLength = str.length();
        int wordLength = word.length();

        for (int i = 0; i < strLength - wordLength + 1; i++) {
            String substring = str.substring(i, wordLength + i);

            if (i > 0 && substring.equals(word)) {
                sb.append(str.substring(i - 1, i));
            }

            if (i < strLength - wordLength && substring.equals(word)) {
                sb.append(str.substring(i + wordLength, i + 1 + wordLength));
            }
        }

        return sb.toString();
    }
}

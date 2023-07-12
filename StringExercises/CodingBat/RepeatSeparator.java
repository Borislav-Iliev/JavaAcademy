package CodingBat;

public class RepeatSeparator {

    public String repeatSeparator(String word, String sep, int count) {
        if (count == 0) {
            return sep;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count - 1; i++) {
            sb.append(word).append(sep);
        }
        return sb.append(word).toString();
    }
}

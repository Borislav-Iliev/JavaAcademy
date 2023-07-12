package CodingBat;

public class OneTwo {

    public static String oneTwo(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length() - 2; i += 3) {
            String substring = str.substring(i, i + 3);
            sb.append(substring.charAt(1)).append(substring.charAt(2)).append(substring.charAt(0));
        }

        return sb.toString();
    }
}

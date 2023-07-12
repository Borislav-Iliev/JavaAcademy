package CodingBat;

public class DoubleChar {

    public static String doubleChar(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            sb.append(element).append(element);
        }

        return sb.toString();
    }
}

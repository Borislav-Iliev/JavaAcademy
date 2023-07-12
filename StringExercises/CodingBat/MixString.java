package CodingBat;

public class MixString {

    public static String mixString(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int smallerLength = Math.min(a.length(), b.length());
        for (int i = 0; i < smallerLength; i++) {
            sb.append(a.charAt(i)).append(b.charAt(i));
        }

        if (a.length() > b.length()) {
            sb.append(a.substring(smallerLength));
        } else if (b.length() > a.length()) {
            sb.append(b.substring(smallerLength));
        }

        return sb.toString();
    }
}

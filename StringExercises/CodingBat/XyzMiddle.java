package CodingBat;

public class XyzMiddle {

    public boolean xyzMiddle(String str) {
        if (!str.contains("xyz")) {
            return false;
        }

        String substring = str.substring(str.length() / 2 - 1, str.length() / 2 + 2);

        if (str.length() % 2 != 0) {
            return substring.equals("xyz");
        }

        return str.substring(str.length() / 2 - 2, str.length() / 2 + 1).equals("xyz") || substring.equals("xyz");
    }
}

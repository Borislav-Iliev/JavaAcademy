package Edabit;

public class Switcharoo {

    public static String flipEndChars(String s) {
        if (s.length() < 2) {
            return "Incompatible.";
        }

        char firstCharacter = s.charAt(0);
        char lastCharacter = s.charAt(s.length() - 1);

        if (firstCharacter == lastCharacter) {
            return "Two's a pair.";
        }

        return String.valueOf(lastCharacter)
                .concat(s.substring(1, s.length() - 1))
                .concat(String.valueOf(firstCharacter));
    }
}

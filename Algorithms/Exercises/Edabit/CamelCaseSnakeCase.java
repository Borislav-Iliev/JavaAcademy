package Edabit;

public class CamelCaseSnakeCase {
    /*
    Create two functions toCamelCase() and toSnakeCase() that each take a single string
    and convert it into either camelCase or snake_case. If you're not sure what these terms
    mean, check the Resources tab above.
     */

    public static void main(String[] args) {

    }

    public static String toCamelCase(String str) {
        String[] tokens = str.split("_");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            if (i == 0) {
                sb.append(word);
                continue;
            }
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
        }

        return sb.toString();
    }

    public static String toSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);

            if (Character.isUpperCase(letter)) {
                sb.append('_').append(Character.toLowerCase(letter));
                continue;
            }

            sb.append(letter);
        }

        return sb.toString();
    }
}

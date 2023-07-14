package Edabit;

public class FindTheMissingLetter {

    /*
    Create a function that takes an array of increasing letters and return the missing letter.
     */

    public static String missingLetter(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            char letter = arr[i].charAt(0);
            char nextLetter = arr[i + 1].charAt(0);

            if (nextLetter - letter > 1) {
                return String.valueOf((char) (letter + 1));
            }
        }

        return "";
    }
}

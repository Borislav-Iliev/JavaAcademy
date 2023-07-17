package Edabit;

public class SevenBoom {

    /*
    Create a function that takes an array of numbers and return "Boom!" if the digit 7
    appears in the array. Otherwise, return "there is no 7 in the array".
     */

    public static String sevenBoom(int[] arr) {
        for (int number : arr) {
            String numberAsString = String.valueOf(number);

            if (numberAsString.contains("7")) {
                return "Boom!";
            }
        }

        return "there is no 7 in the array";
    }
}

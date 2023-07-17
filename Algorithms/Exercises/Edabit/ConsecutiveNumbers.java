package Edabit;

import java.util.*;

public class ConsecutiveNumbers {

    /*
    Create a function that determines whether elements in an array can be re-arranged to form
    a consecutive list of numbers where each number appears exactly once.
     */

    public static boolean cons(int[] arr) {
        int[] sortedNumbers = Arrays
                .stream(arr)
                .sorted()
                .toArray();

        for (int i = 0; i < sortedNumbers.length - 1; i++) {
            int firstNumber = sortedNumbers[i];
            int secondNumber = sortedNumbers[i + 1];

            if (secondNumber - firstNumber > 1 || secondNumber == firstNumber) {
                return false;
            }
        }

        return true;
    }
}

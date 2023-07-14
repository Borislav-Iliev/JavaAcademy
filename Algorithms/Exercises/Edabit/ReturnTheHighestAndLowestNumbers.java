package Edabit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnTheHighestAndLowestNumbers {

    /*
    Create a method that accepts a string of space separated numbers and returns the highest
    and lowest number (as a string).
     */

    public static String highLow(String s) {
        List<Integer> sortedNumbers = Arrays
                .stream(s.split(" "))
                .map(Integer::parseInt)
                .sorted()
                .toList();

        int lowestNumber = sortedNumbers.get(0);
        int highestNumber = sortedNumbers.get(sortedNumbers.size() - 1);

        return String.format("%d %d", highestNumber, lowestNumber);
    }
}

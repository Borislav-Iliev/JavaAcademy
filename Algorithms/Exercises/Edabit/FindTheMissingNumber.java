package Edabit;

import java.util.Arrays;

public class FindTheMissingNumber {

    /*
    Create a method that takes an array of integers between 1 and 10 (excluding one number)
    and returns the missing number.
    */

    public static int missingNum(int[] nums) {
        int count = 1;

        int[] sortedNums = Arrays.stream(nums).sorted().toArray();

        for (int number : sortedNums) {
            if (count != number) {
                return count;
            }
            count++;
        }
        return count;
    }
}

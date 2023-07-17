package Edabit;

public class TheHumbleSequenceOfTheModestNumbers {

    /*
    In this challenge, you have to establish if a positive integer is a Modest number,
    accordingly to the following algorithm:

    Divide the number into two left and right partitions.
    For each combination of left and right parts, you have to check if a condition is true: the remainder of the number divided by the right part is equal to the left part.
    If at least a combination of two parts satisfies the above condition, the number is Modest, otherwise, it's not.

    Given an integer num, implement a function that returns true if num is a Modest number,
    or false if it's not.
     */

    public static boolean isModest(int num) {
        String numAsString = String.valueOf(num);
        StringBuilder leftPart = new StringBuilder();
        StringBuilder rightPart = new StringBuilder();

        for (int i = 0; i < numAsString.length(); i++) {
            leftPart.append(numAsString.charAt(i));

            for (int j = i + 1; j < numAsString.length(); j++) {
                rightPart.append(numAsString.charAt(j));
            }

            if (rightPart.toString().startsWith("0")) {
                rightPart.replace(0, rightPart.lastIndexOf("0") + 1, "");
            }

            if (leftPart.toString().equals("") || rightPart.toString().equals("")) {
                continue;
            }

            if (num % Integer.parseInt(rightPart.toString()) == Integer.parseInt(leftPart.toString())) {
                return true;
            }
            rightPart = new StringBuilder();
        }
        return false;
    }
}

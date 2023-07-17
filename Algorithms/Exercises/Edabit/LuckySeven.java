package Edabit;

public class LuckySeven {

    /*
    Given an array of numbers, return whether it is possible to make the number 7 by adding
    any three different numbers together.
     */

    public static boolean luckySeven(int[] r) {
        for (int i = 0; i < r.length; i++) {
            int currentNumber = r[i];

            for (int j = i + 1; j < r.length - 1; j++) {
                int firstNumber = r[j];

                for (int k = j + 1; k < r.length; k++) {
                    int secondNumber = r[k];

                    if (currentNumber + firstNumber + secondNumber == 7) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}

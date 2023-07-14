package Edabit;

public class HowManyPrimeNumbersAreThere {

    /*
    Create a function that finds how many prime numbers there are, up to the given integer.
     */

    public static int primeNumbers(int num) {
        int count = 0;

        for (int currentNumber = 2; currentNumber <= num; currentNumber++) {
            boolean isPrime = true;
            int divisionCount = 0;

            for (int j = 1; j <= Math.sqrt(currentNumber); j++) {
                if (currentNumber % j == 0) {
                    divisionCount++;
                }

                if (divisionCount > 1) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
            }
        }

        return count;
    }
}

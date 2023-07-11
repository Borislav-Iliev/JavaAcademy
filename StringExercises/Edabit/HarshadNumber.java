package Edabit;

public class HarshadNumber {

    public static boolean isHarshad(int n) {
        int m = n;
        int sum = 0;

        while (n != 0) {
            int d = n % 10;
            sum = sum + d;
            n = n / 10;
        }

        return m % sum == 0;
    }
}

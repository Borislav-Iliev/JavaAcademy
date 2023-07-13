public class Fibonacci {

    private static long[] fibonacciArray;

    public static void main(String[] args) {
        int n = 7;

        fibonacciArray = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        if (fibonacciArray[n] != 0) {
            return fibonacciArray[n];
        }

        long nthFibonacciNumber = fibonacci(n - 1) + fibonacci(n - 2);
        fibonacciArray[n] = nthFibonacciNumber;

        return nthFibonacciNumber;
    }
}

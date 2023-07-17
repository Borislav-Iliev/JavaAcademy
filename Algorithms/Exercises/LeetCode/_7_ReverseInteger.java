package LeetCode;

public class _7_ReverseInteger {

    /*
    Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go
    outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     */

    public int reverse(int x) {
        String xAsString = String.valueOf(x);

        String reversed;

        if (xAsString.startsWith("-")) {
            xAsString = xAsString.replace("-", "");
            reversed = new StringBuilder(xAsString).append("-").reverse().toString();
        } else {
            reversed = new StringBuilder(xAsString).reverse().toString();
        }


        if (Long.parseLong(reversed) > Integer.MAX_VALUE || Long.parseLong(reversed) < Integer.MIN_VALUE) {
            return 0;
        }

        return Integer.parseInt(reversed);
    }
}

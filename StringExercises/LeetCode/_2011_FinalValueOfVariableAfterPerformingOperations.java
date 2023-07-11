package LeetCode;

public class _2011_FinalValueOfVariableAfterPerformingOperations {

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;
        for (String operation : operations) {
            if (operation.contains("+")) {
                x++;
                continue;
            }

            x--;
        }

        return x;
    }
}

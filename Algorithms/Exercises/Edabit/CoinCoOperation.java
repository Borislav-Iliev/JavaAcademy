package Edabit;

public class CoinCoOperation {
    /*
    Let's say that there exists a machine that gives out free coins, but with a twist!

    Separating two people is a wall, and this machine is placed in such a way that both people
    are able to access it. Spending a coin in this machine will give the person on the other side 3
    coins and vice versa.

    If both people continually spend coins for each other (SHARING), then they'll both gain a
    net profit of 2 coins per turn. However, there is always the possibility for someone to act
    selfishly (STEALING): they spend no coins, yet they still receive the generous 3 coin gift
    from the other person!

    The Challenge

    Assuming that both people start with 3 coins each, create a function that calculates both
    people's final number of coins. You will be given two arrays of strings, with each string
    being the words "share" or "steal".
     */

    public static int[] getCoinBalances(String[] r, String[] b) {
        int rightPersonCoins = 3;
        int leftPersonCoins = 3;

        for (int i = 0; i < r.length; i++) {
            String rightPersonAction = r[i];
            String leftPersonAction = b[i];

            if (rightPersonAction.equals(leftPersonAction) && rightPersonAction.equals("share")) {
                rightPersonCoins += 2;
                leftPersonCoins += 2;
            } else if (!rightPersonAction.equals(leftPersonAction)) {
                if (rightPersonAction.equals("steal")) {
                    rightPersonCoins += 3;
                    leftPersonCoins -= 1;
                } else if (leftPersonAction.equals("steal")) {
                    leftPersonCoins += 3;
                    rightPersonCoins -= 1;
                }
            }
        }

        return new int[]{rightPersonCoins, leftPersonCoins};
    }
}

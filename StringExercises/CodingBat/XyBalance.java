package CodingBat;

public class XyBalance {

    public static boolean xyBalance(String str) {
        if (!str.contains("x") && !str.contains("y")) {
            return true;
        }

        int xIndex = str.lastIndexOf('x');
        int yIndex = str.lastIndexOf('y');

        return xIndex < yIndex;
    }
}

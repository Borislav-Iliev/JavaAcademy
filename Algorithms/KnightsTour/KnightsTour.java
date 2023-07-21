public class KnightsTour {
    public static void main(String[] args) {
        int[][] chessBoard = {
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1}
        };

        solveChessBoard(chessBoard);
    }

    private static void printChessBoard(int[][] chessBoard) {
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveChessBoard(int[][] chessBoard) {
        chessBoard[0][0] = 0;

        int[] possibleRowMovements = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] possibleColMovements = {1, 2, 2, 1, -1, -2, -2, -1};

        int counter = 1;

        if (moveKnight(chessBoard, 0, 0, counter, possibleRowMovements, possibleColMovements)) {
            printChessBoard(chessBoard);
            return true;
        } else {
            System.out.println("Could find a solution!");
            return false;
        }
    }

    private static boolean moveKnight(int[][] chessBoard, int row, int col, int counter,
                                      int[] rowMovements, int[] colMovements) {
        if (counter == 64) {
            return true;
        }

        for (int i = 0; i < chessBoard.length; i++) {
            int currentRow = row + rowMovements[i];
            int currentCol = col + colMovements[i];

            if (isSafe(chessBoard, currentRow, currentCol)) {

                chessBoard[currentRow][currentCol] = counter;

                if (moveKnight(chessBoard, currentRow, currentCol, counter + 1, rowMovements, colMovements)) {
                    return true;
                } else {
                    chessBoard[currentRow][currentCol] = -1;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[][] chessBoard, int row, int col) {
        if (row >= chessBoard.length) {
            return false;
        }

        if (row < 0) {
            return false;
        }

        if (col >= chessBoard[row].length) {
            return false;
        }

        if (col < 0) {
            return false;
        }

        if (chessBoard[row][col] != -1) {
            return false;
        }

        return true;
    }
}

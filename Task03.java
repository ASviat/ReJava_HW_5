public class Task03 {
    public static void main(String[] args) {

        String[][] myBoard = new String[8][8];
        for (int i = 0; i < myBoard.length; i++) {
            for (int j = 0; j < myBoard.length; j++) {
                myBoard[i][j] = "-";
            }
        }

        Solved(0, myBoard);
        for (int i = 0; i < myBoard.length; i++) {
            for (int j = 0; j < myBoard.length; j++) {
                System.out.print(myBoard[i][j] + " ");
            }
            System.out.println();
        }
    }
    

    private static boolean PlaceQueen(int row, int col, String[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == "Ф") {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == "Ф") {
                return false;
            }
        }
        for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == "Ф") {
                return false;
            }
        }
        return true;
    }

    private static boolean Solved(int row, String[][] board) {
        if (row == board.length) {
            return true;
        }
        for (int i = 0; i < board.length; i++) {
            if (PlaceQueen(row, i, board)) {
                board[row][i] = "Ф";
                if (Solved(row + 1, board)) {
                    return true;
                }
                board[row][i] = "-";
            }
        }
        return false;
    }
}
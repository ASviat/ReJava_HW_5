/**
 * 
 * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И
 * вывести Доску. Пример вывода доски 8x8
 * 
 * 0x000000
 * 0000x000
 * 00x00000
 */
public class Task03 {

    public static void main(String[] args) {
        String[][] myBoard = new String[8][8];
        for (int i = 0; i < myBoard.length; i++) {
            for (int j = 0; j < myBoard.length; j++) {
                myBoard[i][j] = "0";
            }
        }

        myBoard[0][0] = "Ф";

        PrintMatrix(myBoard);

        int row = 0;
        int column = 0;
        int counter = 0;
        while (counter != 8) {
            if (BoardHorizontal(myBoard, column)) {
                column++;
                
                if (BoardVertical(myBoard, row)) {
                    try {
                        row++;
                    } catch (Exception e) {
                        row--;
                    } 
                }
                if (BoardDiagonal(myBoard, column, row)) {
                    try {
                        column+=2;
                    row++;
                    } catch (Exception e) {
                        column-=2;
                        row++;
                    } 
                }
            }
        }

    }

    private static boolean BoardHorizontal(String[][] myBoard, int myColumn) {
        for (int i = 0; i < myBoard.length; i++) {
            if (myBoard[myColumn][i].equals("Ф")) {
                return true;
            }
        }
        return false;
    }

    private static boolean BoardVertical(String[][] myBoard, int myRow) {
        for (int j = 0; j < myBoard.length; j++) {
            if (myBoard[myRow][0].equals("Ф")) {
                return true;
            }
        }
        return false;
    }

    private static boolean BoardDiagonal(String[][] myBoard, int myColumn, int myRow) {

        for (int j = 0; j < myBoard.length; j++) {
            if (myBoard[myColumn][myRow].equals("Ф")) {
                return true;

            }
        }
        return false;
    }

    public static void PrintMatrix(String[][] myMatrix) {
        for (int i = 0; i < myMatrix.length; i++) {
            for (int j = 0; j < myMatrix.length; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
// Написать метод Solved, который будет проверять, можно ли поставить ферзь в данную позицию.

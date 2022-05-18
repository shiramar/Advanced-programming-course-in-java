import javax.swing.*;

public class Logic {
    public final int ROW = 6, COL = 7;
    public final int R = 1,B=2;
    int isWin=0;
    String winMessage;


    public int logicMatrix[][] = new int[ROW][COL];

    //initialize the matrix to o
    public void initializeMatrix() {
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++) {
                logicMatrix[i][j] = 0;
            }

    }

    //This function checks if there is a row / column / diagonal with 4 similar disks
    public boolean checkWinner() {
        int row, col;
        //check row
        for (row = 0; row < ROW - 3; row++) {
            for (col = 0; col < COL; col++)
                if (((logicMatrix[row][col]) == (logicMatrix[row + 1][col])) &&
                        ((logicMatrix[row + 1][col]) == (logicMatrix[row + 2][col])) &&
                        ((logicMatrix[row + 2][col]) == (logicMatrix[row + 3][col]))) {
                    isWin=checkMatrix( row, col);
                }
        }
        //check column
        for (row = 0; row < ROW; row++)
            for (col = 0; col < COL - 3; col++) {
                if (((logicMatrix[row][col]) == (logicMatrix[row][col + 1])) &&
                        ((logicMatrix[row][col + 1]) == (logicMatrix[row][col + 2])) &&
                        ((logicMatrix[row][col + 2]) == (logicMatrix[row][col + 3]))) {
                    isWin=checkMatrix( row, col);
                }
            }

        //check up diagonal 1
        for (row = 0; row < ROW - 3; row++) {
            for (col = 0; col < COL - 3; col++) {
                if (((logicMatrix[row][col]) == (logicMatrix[row + 1][col + 1])) &&
                        ((logicMatrix[row + 1][col + 1]) == (logicMatrix[row + 2][col + 2])) &&
                        ((logicMatrix[row + 2][col + 2]) == (logicMatrix[row + 3][col + 3]))) {
                    isWin=checkMatrix( row, col);
                }
            }
        }

        //check up diagonal 2
        for (row = (ROW - 1); row >= ROW - 3; row--)
            for (col = 0; col < COL - 3; col++) {
                if (((logicMatrix[row][col]) == (logicMatrix[row - 1][col + 1])) &&
                        ((logicMatrix[row - 1][col + 1]) == (logicMatrix[row - 2][col + 2])) &&
                        ((logicMatrix[row - 2][col + 2]) == (logicMatrix[row - 3][col + 3]))) {
                    isWin=checkMatrix( row, col);
                }
            }
        //case win
        if (isWin!=0){
            winMessagePrint();
            return true;
        }
        return false;
    }

    //this function check if there is a winner
    private int checkMatrix(int row, int col){
        if (logicMatrix[row][col] == R) {
            winMessage = "\nThe red player win!!\n";
            isWin = R;
        }
        else if (logicMatrix[row][col] == B) {
            winMessage = "\nThe blue player win!!\n";
            isWin = B;
        }
        return isWin;
    }

    //this function print a massage winner
    private void winMessagePrint() {
        JOptionPane.showMessageDialog(null, winMessage);
        winMessage=null;
        isWin=0;

    }

}

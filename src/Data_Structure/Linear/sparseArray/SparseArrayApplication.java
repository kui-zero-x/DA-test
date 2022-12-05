package Data_Structure.Linear.sparseArray;

public class SparseArrayApplication {


    /**
     * @describe 稀疏数组压缩二维数组
     * @info
     */
    public void convert() {

        //准备好一个4*4棋盘，0表示没有棋子，其他数表示有棋子
        int[][] board = new int[4][4];

        //初始化棋盘
        board[1][1] = 1;
        board[2][2] = 2;
        board[3][3] = 3;
        board[4][4] = 4;

        //统计棋盘非零数个数
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) sum++;
            }
        }

        //二维数组 -> 稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = 4;
        sparseArray[0][1] = 4;
        sparseArray[0][2] = sum;
        int k = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] != 0) {
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = board[i][j];
                    k++;
                }
            }
        }
    }

    /**
     * @describe 稀疏数组恢复为二维数组
     * @info
     */
    public void revert() {

        //稀疏数组 -> 二维数组
        int[][] sparseArray = new int[5][3];
        sparseArray[0][0] = 4;
        sparseArray[0][1] = 4;
        sparseArray[0][2] = 4;
        for (int i = 1; i < 5; i++) {
            sparseArray[i][0] = i;
            sparseArray[i][1] = i;
            sparseArray[i][2] = i;
        }

        int[][] board = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < 5; i++) {
            board[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
    }

}

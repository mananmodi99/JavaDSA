package LeetcodeProblems;

public class SodukuSolver {
    public static void solveSudoku(char[][] board) {
        int n = 9;
        int[][] soduku = new int[9][9];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] == '.')
                    soduku[i][j] = 0;
                else
                    soduku[i][j] = (int) board[i][j] - 48;
            }
        }
        if(solvingSoduku(soduku)){
            for(int i = 0; i<n; i++){
                for(int j = 0; j<9; j++){
                    if(board[i][j] == '.')
                        board[i][j] = (char) ((int) soduku[i][j]+48);
                }
            }
        }
    }
    public static boolean solvingSoduku(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 0){
                    for(int value = 1; value <= 9; value++){
                        if(isPlace(board, i, j, value)){
                            board[i][j] = value;

                            if(solvingSoduku(board))
                                return true;
                            else
                                board[i][j] = 0;
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPlace(int[][] soduku, int i, int j, int value){
        for(int x = 0; x<9; x++){
            if(soduku[x][j] == value || soduku[i][x] == value){
                return false;
            }
        }
        int grid_x = i - i%3;
        int grid_y = j - j%3;
        for(int x = 0; x<3; x++){
            for(int y = 0; y<3; y++){
                if(soduku[x+grid_x][y+grid_y] == value)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char board[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }
}

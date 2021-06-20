package Recursion;

public class CountNQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[8][8];
        System.out.println(Nways(board, 0));
        PrintingBoard(board, 0, "");
    }
    public static int Nways(boolean[][] board, int row){
        //Base
        if(row == board.length)
            return 1;
        //Recursive
        int count = 0;
        for(int col = 0; col<board[row].length; col++){
         if(QueenCanBePlaced(board, row, col)){
             board[row][col] = true;
             count += Nways(board, row+1);
             board[row][col] = false;
         }
        }
        return count;
    }
    public static boolean QueenCanBePlaced(boolean[][] board, int row, int col){
        //for same col - L1
        for (int i=row; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        //for left diag
        for(int i=row,j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]){
                return false;
            }
        }

        //for right diag
        for(int i=row,j=col; i>=0 && j<board.length; i--, j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }
    public static void PrintingBoard(boolean[][] board, int row, String ans){
        //base
        if (row == board.length) {
            System.out.println("{ " + ans + " }");
            return;
        }
        //recursive
        for(int col = 0; col<board[row].length; col++){
                if(QueenCanBePlaced(board, row, col)){
                    board[row][col] = true;
                    PrintingBoard(board, row+1, ans + row + " - " + col + ", ");
                    board[row][col] = false;
                }
        }
    }
}

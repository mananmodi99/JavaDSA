package Backtracking;

public class QueenCombination {
    public static void main(String[] args) {
        boolean[] board = new boolean[4];
        PlacingQueen(board, 2, 0,-1, "");
        PlacingQueenWRTBox(board, 0, 0, 2, "");
    }

    private static void PlacingQueenWRTBox(boolean[] board, int col, int qpsf, int tq, String ans) {
    //base
        //+ve
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        if(col == board.length){
            return;
        }
        //-ve
        //recursive
        board[col] = true;
        PlacingQueenWRTBox(board, col+1, qpsf+1, tq, ans+"b"+col);
        board[col] = false;
        PlacingQueenWRTBox(board, col+1, qpsf, tq, ans);
    }

    private static void PlacingQueen(boolean[] board, int tq, int qpsf,int lbu, String ans) {
        //base
        if(qpsf == tq){
            System.out.println(ans);
            return;
        }
        //recursive
        for(int i = lbu+1; i< board.length; i++){
            if(!board[i]){
                board[i] = true;//do
                PlacingQueen(board, tq, qpsf+1, i,ans+"q"+qpsf+"b"+i);
                board[i] = false;//undo
            }
        }
    }
}

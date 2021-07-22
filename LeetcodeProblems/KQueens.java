package LeetcodeProblems;

import java.util.ArrayList;
import java.util.List;

public class KQueens {
    public static List<List<String>> solveKQueens(int n, int k) {
        List<List<String>> list = new ArrayList<>();
        int[][] chess = new int[n][n];
        QueenPlacement(list, chess, 0, k, 0, n);
        return list;
    }
    public static void QueenPlacement(List<List<String>> list, int[][] chess, int qpsf, int tq, int row, int n){
        //Base
        if(qpsf == tq){
            //chess[row][col] = 1;
            List<String> currAns = StrConv(chess, n);
            list.add(currAns);
            return;
        }

        if(row >= n){
            return;
        }

        //Main Rec
        //Place Here
        for(int col = 0; col<n; col++){
            if(isQueenSafe(chess, row, col, n)){
                chess[row][col] = 1;
                QueenPlacement(list, chess, qpsf+1, tq, row+1, n);
                chess[row][col] = 0;
            }
        }
        QueenPlacement(list, chess, qpsf, tq, row+1, n);

    }
    public static boolean isQueenSafe(int[][] chess, int row, int col, int n){
        //Vertically up
        for(int i = row-1; i>=0; i--){
            if(chess[i][col] == 1){
                return false;
            }
        }
        //diagonally Left
        int r = row-1, c = col-1;
        while(r>=0 && c>=0){
            if(chess[r][c] == 1)
                return false;
            r--;
            c--;
        }
        //Diagonally Right
        r = row-1;
        c = col+1;
        while(r>=0 && c<n){
            if(chess[r][c] == 1)
                return false;
            r--;
            c++;
        }

        //Horizontally Left
        for(int i = col; i>=0; i--){
            if(chess[row][i] == 1){
                return false;
            }
        }
        return true;
    }
    public static List<String> StrConv(int[][] chess, int n){
        List<String> list = new ArrayList<>();

        for(int i = 0; i<n; i++){
            String str = "";
            for(int j = 0; j<n; j++){
                if(chess[i][j] == 1)
                    str = str + 'Q';
                else
                    str = str + ".";
            }
            list.add(str);
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(solveKQueens(4, 3));
    }
}

package LeetcodeProblems;
import java.util.*;
//Problem Link: https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZero {
    public void Best(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean isColZero = false;
        for(int i = 0; i<m; i++){
            if(matrix[i][0] == 0){ isColZero = true;}
            for(int j = 1; j<n; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i<m; i++){
            for(int j = 1; j<n; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for(int j = 0; j<n; j++){
                matrix[0][j] = 0;
            }
        }
        if(isColZero){
            for(int i = 0; i<m; i++){

                matrix[i][0] = 0;
            }
        }
    }

    public void Better(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(rows.contains(i) == true || cols.contains(j) == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void Naive(int[][] matrix) {
        //TC : O(n**3)
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == 0){
                    for(int k = 0; k<n; k++){
                        if(matrix[i][k] != 0)
                            matrix[i][k] = Integer.MAX_VALUE-100;
                        else
                            matrix[i][k] = 0;
                    }
                    for(int k = 0; k<m; k++){
                        if(matrix[k][j] != 0)
                            matrix[k][j] = Integer.MAX_VALUE-100;
                        else
                            matrix[k][j] = 0;
                    }
                }
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == Integer.MAX_VALUE-100){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}





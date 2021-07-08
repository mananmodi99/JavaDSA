package LeetcodeProblems;
//Problem Link: https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m; i++){
            for(int j = i; j<n; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n/2; j++){//n/2
                int temp2 = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp2;
            }
        }
    }
}

package DynamicProgramming;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i[]:dp) Arrays.fill(i, -1);
        return minSum(grid, 0, 0, m, n, dp);
    }
    public int minSum(int[][] mat, int i, int j, int m, int n, int[][] dp){
        if( i>=m || j>=n) return Integer.MAX_VALUE;
        if(i == m-1 && j == n-1)  return mat[m-1][n-1];
        if(dp[i][j] == -1)
            dp[i][j] = mat[i][j] + Math.min(minSum(mat, i+1, j, m, n, dp), minSum(mat, i, j+1, m, n, dp));
        return dp[i][j];
    }
}

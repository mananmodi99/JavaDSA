package DynamicProgramming;

public class RodCuttingProblem {
    public static int RodCuttingProblem(int[] arr, int n, int len){
        int[][] dp = new int[n+1][len+1];
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<len+1; j++){
                if(arr[i-1]<=j){
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]], dp[i-1][j]);
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][len];
    }
}

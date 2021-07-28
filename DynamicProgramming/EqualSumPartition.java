package DynamicProgramming;

public class EqualSumPartition {
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int i = 0; i<N; i++){sum += arr[i];}
        if(sum%2!=0){
            return 0;
        }
        boolean[][] dp = new boolean[N+1][(sum/2)+1];
        if(subsetSum(arr, N, sum/2, dp))
            return 1;
        else return 0;
    }
    static boolean subsetSum(int[] arr, int n, int sum, boolean[][] dp){
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<sum+1; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
            }
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
                if(i == 0) dp[i][j] = false;
                if(j == 0) dp[i][j] = true;
                else if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]]||dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}

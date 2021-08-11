package DynamicProgramming;

public class MinimumSubsetPartition {
    public int minDifference(int arr[], int n)
    {
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
        }
        //Subset Sum Code
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i<n+1; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i<=sum/2; i++){
            if(dp[n][i]){
                minDiff = Math.min(minDiff, sum - 2*i);
            }
        }
        return minDiff;
    }
    public int cnt_SubsetwithGivenDiff(int[] arr, int n, int diff) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        sum = (sum + diff) / 2;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
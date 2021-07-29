package DynamicProgramming;

public class TargetSum {
    public int findTargetSumWays(int[] arr, int target) {
        //Subset Difference Count Sum
        int sum = 0;
        int n = arr.length;

        for (int k : arr) {
            sum += k;
        }

        if(target > sum || (target+sum)%2 == 1)
            return 0;

        sum = (sum+target)/2;

        int[][] dp = new int[n+1][sum+1];

        for(int i = 0; i<n+1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i<n+1; i++){
            for(int j = 0; j<sum+1; j++){
                if(arr[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
            }
        }

        return dp[n][sum];
    }
}

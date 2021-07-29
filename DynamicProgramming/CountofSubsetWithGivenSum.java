package DynamicProgramming;

public class CountofSubsetWithGivenSum {
    public static int cnt_SubsetSum(int[] arr, int n, int sum){
        //Initialization
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < sum+1;i++)
            dp[0][sum] = 0;
        for (int i = 0; i < n+1;i++)
            dp[i][0] = 1;
        //Tabulation
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<sum+1; j++){
                if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }

    public static void main(String[] args) {
        System.out.println(cnt_SubsetSum(new int[]{2,3,5,6,8,10}, 5, 10));
    }
}

package DynamicProgramming;
import java.util.*;
public class SubsetSum {
    public static void main(String[] args) {
        System.out.println(isSubsetSum(5, new int[]{2,3, 7, 8, 10}, 11));
    }
    static boolean isSubsetSum(int N, int arr[], int sum){
        boolean[][] dp = new boolean[N+1][sum+1];

        return SubsetSum(N, arr, sum, dp);
    }
    static boolean SubsetSum(int n, int[] arr,int sum, boolean[][] dp){
        if(n == 0) return false;
        if(sum == 0) return true;
        if(!dp[n][sum]){
            if(arr[n-1]<=sum){
                dp[n][sum] = SubsetSum(n-1, arr, sum-arr[n-1], dp) || SubsetSum(n-1, arr, sum, dp);
            }
            else{
                dp[n][sum] = SubsetSum(n-1, arr, sum, dp);
            }
        }
        return dp[n][sum];
    }
    static boolean SubsetSum_tab(int n, int[] arr,int sum, boolean[][] dp){
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<sum+1; j++){
                if(i == 0) return false;
                if(j==0) return true;
                else if(arr[i-1]<=j)
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}

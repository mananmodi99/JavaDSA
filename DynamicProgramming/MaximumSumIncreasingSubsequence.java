package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {44 ,42 ,38 ,21 ,15 ,22 ,13 ,27};
        System.out.println(lis_sum_dp(arr));
    }

    private static int lis_sum_dp(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for(int i= 1; i<arr.length; i++){
            int curr_max_sum = arr[i];
            for(int j = 0; j<i; j++){
                if(arr[j]<arr[i]){
                    curr_max_sum = Math.max(curr_max_sum, dp[j]+arr[i]);
                }

            }dp[i] = curr_max_sum;
        }
        int max_sum = dp[0];
        for(int i = 1; i<dp.length; i++){
            System.out.print(dp[i] + ", ");
            max_sum = Math.max(max_sum, dp[i]);
        }

        return max_sum;
    }

}

package DynamicProgramming;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int[] arr2= {10, 22, 9, 33, 21, 50, 41, 60, 80, 1};
        System.out.println(lis_dp_tab(arr));
    }
    static int lis_dp_tab(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        for(int i = 1; i<dp.length; i++){
            int curr_max = 0;
            for(int j = 0; j<i; j++){
                if(arr[i]>arr[j]){
                    curr_max = Math.max(curr_max, dp[j]);
                }
            }
            dp[i] = 1 + curr_max;
        }
        int max = dp[0];
        for(int i : dp)
            max = Math.max(max, i);
        return max;
    }
}

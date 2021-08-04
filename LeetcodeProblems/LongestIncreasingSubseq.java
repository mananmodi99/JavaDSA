package LeetcodeProblems;

public class LongestIncreasingSubseq {
    class Solution {
        public int lengthOfLIS(int[] arr) {
            int n = arr.length;
            int[] dp = new int[n+1];
            dp[0] = 1;
            int overallMax = 1;
            for(int i = 1; i<n; i++){
                int curr_max = 0;
                for(int j = i-1; j>=0; j--){
                    if(arr[j]<arr[i]){
                        curr_max = Math.max(curr_max, dp[j]);
                    }
                }
                dp[i] = curr_max+1;
                overallMax = Math.max(overallMax, dp[i]);
            }
            return overallMax;
        }
    }
}

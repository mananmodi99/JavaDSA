package DynamicProgramming;

public class MaximumSumIncreasingSubSeq {
    public static int maxSumIS(int arr[], int n)
    {
        //code here.
        int[] dp = new int[n];
        dp[0] = arr[0];
        int max = arr[0];
        for(int i = 1; i<n; i++){
            int curr = arr[i];
            for(int j = i-1; j>=0; j--){
                if(arr[j]<arr[i]){
                    curr = Math.max(curr , dp[j]+arr[i]);
                }
            }
            dp[i] = curr;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        maxSumIS(new int[]{1,102,2,3,100,4,5}, 7);
    }
}

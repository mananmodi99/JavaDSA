package DynamicProgramming;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {8,100,150, 10,12,14,10};
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
    public static void lis_binarySearch(int arr[]) {
        int tail[] = new int[arr.length];
        int len = 1;
        tail[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>tail[len-1]){
                tail[len] = arr[i];
                len++;
            }
            else{
                int swapper = binarySearchLIS(tail, len, arr[i]);
                tail[swapper] = arr[i];
            }
        }
        System.out.println(len);
    }
    public static int binarySearchLIS(int[] tail, int len, int item){
        int lo = 0;
        int hi = len-1;
        int mid = 0;
        while(hi>lo){
            mid = (lo+hi)/2;
            if(tail[mid]>=item){ hi = mid;}
            else{ lo = mid+1;}
        }
        return hi;
    }
}

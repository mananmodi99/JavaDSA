package LeetcodeProblems;

public class MaximumSubArray {
    //Problem link: https://leetcode.com/problems/maximum-subarray/
    public static int Naive(int arr[]){
        //O(n**3)
        int max = 0;
        for(int i = 0; i<arr.length; i++){
            for(int j = i; j<arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++)
                    sum += arr[k];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
    static int Better(int arr[]){
        //O(n**2)
        int max = 0;
        for(int i = 0; i< arr.length; i++){
            int sum = 0;
            for(int j = i; j<arr.length; j++) {
                sum += arr[j];
                max = Math.max(sum, max);
            }
        }
        return max;
    }
    public int maxSubArray(int[] arr) {
        //O(n)
        int max = Integer.MIN_VALUE;
        int curr_max = 0;
        for(int i = 0; i<arr.length; i++){
            curr_max += arr[i];
            max = Math.max(curr_max, max);
            if(curr_max<0)
                curr_max = 0;
        }
        return max;
    }
}

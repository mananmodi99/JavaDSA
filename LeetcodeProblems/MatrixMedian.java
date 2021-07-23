package LeetcodeProblems;
//Problem Link: https://www.interviewbit.com/old/problems/matrix-median/
public class MatrixMedian {
    public static void main(String[] args) {
        int arr[][] = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(findMedian(arr));
    }
    public int findMedian(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int hi = Integer.MIN_VALUE;
        int lo = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            lo = Math.min(lo, arr[i][0]);
            hi = Math.max(hi, arr[i][m-1]);
        }
        int median = 1+(n*m)/2;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            int count = 0;
            for(int i = 0; i<n; i++)
                count += countBS(arr[i], mid, m);
            if(count<median)
                lo = mid+1;
            else
                hi = mid;
        }
        return lo;
    }
    public int countBS(int[] arr, int mid, int m){
        int lo = 0;
        int hi = m-1;
        while(lo<=hi){
            int mid_2 =lo+(hi-lo)/2;
            if(arr[mid_2]<=mid)
                lo = mid_2+1;
            else
                hi = mid_2-1;
        }
        return lo;
    }
}

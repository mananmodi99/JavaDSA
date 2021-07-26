package LeetcodeProblems;

public class AllocateMinNumberofPages {
    public static int findPages(int[] arr,int n,int m)
    {
        if(n<m) return -1;
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            max = Math.max(max, arr[i]);
            sum = sum + arr[i];
        }
        int lo = max, hi = sum, res = -1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isValid(arr, mid, n, m)){
                res = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return res;
    }
    public static boolean isValid(int[] arr, int mid, int n, int m){
        int curr_stud = 1, sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i];
            if(sum>mid){
                sum = arr[i];
                curr_stud++;
            }
            if(curr_stud>m){
                return false;
            }
        }
        return true;
    }
}

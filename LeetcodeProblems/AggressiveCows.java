package LeetcodeProblems;

import java.util.*;

public class AggressiveCows {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test>0){
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(min_maxDistbwcow(arr, n, c));
            test--;
        }
    }
    public static int min_maxDistbwcow(int[] arr, int n, int c){
        if(n<c) {
            return -1;
        }
        Arrays.sort(arr);
        int lo = arr[0];
        int hi = arr[n-1]-arr[0];
        int res = -1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(isValid(arr, mid, n, c)){
                res = mid;
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return res;
    }
    public static boolean isValid(int[] arr, int mid, int n, int c){
        int curr_cow = 1, prev = arr[0];
        for(int i = 1; i<n; i++){
            if(arr[i]-prev>=mid){
                prev = arr[i];
                curr_cow++;
            }
        }
        if(curr_cow<c)
            return false;
        return true;
    }
}

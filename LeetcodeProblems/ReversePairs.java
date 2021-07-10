package LeetcodeProblems;
import java.util.*;
public class ReversePairs {
    public static void main(String[] args) {
        System.out.println(reversePairs(new int[]{1,3,2,3,1}));
    }
    public static int Naive(int[] arr) {
        int cnt = 0;
        for(int i = 0; i<arr.length-1; i++){
            int curr_i = arr[i];
            for(int j = i+1; j<arr.length; j++){
                int curr_j = Math.abs(2*arr[j]);
                if(curr_i>curr_j) cnt++;
            }
        }
        return cnt;
    }
    public static int reversePairs(int[] arr) {
        int cnt = 0;
        int lo = 0;
        int hi = arr.length-1;
        cnt = sortFunc(arr, lo, hi);
        return cnt;
    }
    public static int sortFunc(int[] arr, int lo, int hi){
        int count = 0;
        if(lo<hi){
            int mid = lo+(hi-lo)/2;
            count += sortFunc(arr, lo, mid);
            count += sortFunc(arr, mid+1, hi);
            count += merge2Arr(arr, lo, hi, mid);
        }
        return count;
    }
    public static int merge2Arr(int[] arr, int lo, int hi, int mid){
        int cnt = 0;
        int[] left = Arrays.copyOfRange(arr, lo, mid+1);
        int[] right = Arrays.copyOfRange(arr, mid+1, hi+1);
        int j1 = mid+1;
        for(int i1 = lo; i1 <= mid; i1++){
            while(j1<=hi && arr[i1]>2*(long) arr[j1]){
                j1++;
            }
            cnt += j1-(mid+1);
        }
        int i = 0, j = 0, k = lo;
        while(i<left.length && j<right.length){
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while(i<left.length)
            arr[k++] = left[i++];
        while(j<right.length)
            arr[k++] = right[j++];
        return cnt;
    }


}

package LeetcodeProblems;

public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[arr.length-1];
        int lo = 0, hi = n-2;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == arr[mid^1]){//Left Half
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return arr[lo];
    }
}

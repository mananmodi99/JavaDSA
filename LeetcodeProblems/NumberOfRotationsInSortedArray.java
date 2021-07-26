package LeetcodeProblems;

public class NumberOfRotationsInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,0,1,2};
        int n = arr.length;
        System.out.println(rotations(arr,n));
    }

    private static int rotations(int[] arr, int n) {
        int lo = 0, hi = arr.length-1, min = 0;
        while(lo<=hi){
            if(arr[lo]<arr[hi]){
                return lo;
            }
            int mid = (lo+hi)/2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                return mid;
            }
            if(arr[lo]<=arr[mid])//l side sorted
                lo = mid+1;
            else if(arr[mid]<=arr[hi])//Right side sorted
                hi = mid-1;
        }
        return min;
    }
}

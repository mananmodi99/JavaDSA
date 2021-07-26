public class SearchInRotatedSortedArray {
    public static int search(int[] arr, int target) {
        int n = arr.length;
        int lo = 0, hi = arr.length-1, min = 0;
        while(lo<=hi){
            if(arr[lo]<arr[hi]){
                min = lo;
                break;
            }
            int mid = (lo+hi)/2;
            int prev = (mid+n-1)%n;
            int next = (mid+1)%n;
            if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                min = mid;
                break;
            }
            if(arr[lo]<=arr[mid])//l side sorted
                lo = mid+1;
            else if(arr[mid]<=arr[hi])//Right side sorted
                hi = mid-1;
        }
        int idx = BSidx(arr, 0, min-1, target);
        return (idx==-1)?BSidx(arr, min, n-1, target):idx;
    }

    public static int BSidx(int[]arr, int lo, int hi, int target){
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid] == target)
                return mid;
            if(arr[mid]<target)
                lo = mid+1;
            else
                hi = mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4,5,6,7,0,1,2}, 6));
    }
}

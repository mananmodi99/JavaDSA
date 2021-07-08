package Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int arr[] = {8, 100, 150, 10, 12, 14, 10};
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

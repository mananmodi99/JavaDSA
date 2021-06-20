package Arrays;
import java.util.*;
public class LinearTimeSorting {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        display(LinearTimeSort(arr));
    }
    public static int[] LinearTimeSort(int arr[]){
        int lo = 0,mid = 0,hi = arr.length-1;
        while(hi>=mid){
            if(arr[mid]==0){
                swap(arr, lo, mid);
                lo++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else if(arr[mid] == 2){
                swap(arr, hi, mid);
                hi--;
                //mid++;
            }
        }
        return arr;
    }
    public static void swap(int[] arr, int swap1, int swap2){
        arr[swap1] = arr[swap1] + arr[swap2];
        arr[swap2] = arr[swap1] - arr[swap2];
        arr[swap1] = arr[swap1] - arr[swap2];
    }
    public static void display(int[] arr){
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}

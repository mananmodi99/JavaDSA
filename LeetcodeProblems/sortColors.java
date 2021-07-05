package LeetcodeProblems;

public class sortColors {
    //Problem Link: https://leetcode.com/problems/sort-colors/
    public void sortColors(int[] arr) {
        int lo = 0, hi = arr.length-1, mid = 0;
        while(mid<=hi){
            if(arr[mid] == 0){
                swap(arr, lo, mid);
                lo++;
            }
            if(arr[mid] == 2){
                swap(arr, hi, mid);
                hi--;
            }
            else{
                mid++;
            }
        }

    }
    static void swap(int arr[], int one, int two){
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
}
//Based on Linear Time Sorting or Dutch National Flag

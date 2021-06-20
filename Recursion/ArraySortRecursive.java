package Recursion;

public class ArraySortRecursive {
    public static void main(String args[]){
        int arr[] = {3,4,5,6,7};
        System.out.println(isSort(arr, 0));
    }
    public static boolean isSort(int arr[], int index){
        if(index == arr.length-1){
            return true;
        }
        if(arr[index]>arr[index+1]){
            return false;
        }
        else{
            return isSort(arr, index+1);
        }
    }

}

package Recursion;

public class BubbleSortRecursive {
    public static void main(String[] args) {
        int[] arr = {1,5,4,3,7,8};
        displayInput(arr);
        BubbleSorting(arr, 0, arr.length-1);
        displayInput(arr);

    }
    public static void displayInput(int[] arr){
        System.out.print("[");
        for (int val :
                arr) {
            System.out.print(val + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void BubbleSorting(int arr[], int start, int end){
        System.out.print("[");

        System.out.print("]");
        System.out.println();
        if(end == 0){
            return;
        }
        if(start == end){
            BubbleSorting(arr, 0, end-1);
            return;
        }
        if(arr[start]>arr[start+1]){
            int temp = arr[start];
            arr[start] = arr[start+1];
            arr[start+1] = temp;
        }
        BubbleSorting(arr, start+1, end);


    }
}

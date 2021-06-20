package Arrays;
//Time Complexity: O(nlogn)
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        int array[] = takeInput();
        //displayInput(array);
        SelectionSort(array);

    }
    public static int[] takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Size ?");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i< arr.length;i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void displayInput(int[] arr){
        for (int val :
                arr) {
            System.out.println(val);
        }
    }
    public static void SelectionSort(int[] array){
        for(int  i=0; i<array.length-1; i++){
            int minIndex = i;
            for(int j=i+1; j<array.length; j++){
                if(array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        for (int val:array) {
            System.out.println(val);
        }
    }
}

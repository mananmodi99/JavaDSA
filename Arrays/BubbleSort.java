package Arrays;
//Time Complexity: O(n^2)
import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        int array[] = takeInput();
        displayInput(array);
        BubbleSort(array);

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
        System.out.print("[");
        for (int val :
                arr) {
            System.out.print(val + ", ");
        }
        System.out.print("]");
        System.out.println();
    }
    public static void BubbleSort(int[] array){
        for(int i=0; i< array.length-1; i++)//counterOfSortingElems
            {
            for(int j=0; j< array.length-1-i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                displayInput(array);
            }
        }
        for (int val:array) {
            System.out.println(val);
        }
    }
}

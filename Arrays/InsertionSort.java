package Arrays;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = takeInput();
        //displayInput(array);
        InsertionSort(array);

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
    public static void InsertionSort(int[] array){
        for(int i=1; i<= array.length-1; i++){
            int val = array[i];
            int j = i-1;
            while(j>=0 && array[j]>val){
                array[j+1] = array[j];
                j--;
            }
            array[j+1]= val;
            }
        for (int val : array) {
            System.out.println(val);
        }
    }
}

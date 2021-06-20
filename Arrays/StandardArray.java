package Arrays;

import java.util.Scanner;

public class StandardArray {

    public static void main(String[] args) {
        int array[] = takeInput();
        displayInput(array);

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
        for (int val:
             arr) {
            System.out.println(val);
        }
    }
}

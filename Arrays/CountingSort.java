package Arrays;

import java.util.Scanner;

public class CountingSort {
    public static void main(String args[]) {
        // Your Code Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++ ){
            arr[i] = sc.nextInt();
            if(max < arr[i])
                max = arr[i];
        }
        int[] count = new int[max+1];
        for(int i=0; i<n; i++){
            count[arr[i]]++;
        }

        //runcount
        for(int i=1; i<max+1; i++){
            count[i] += count[i-1];
        }

        //sortation --> Yes!I made this word
        int sorted[] = new int[n];
        for(int i=n-1; i>=0; i--){
            sorted[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        display(sorted);
    }
    private static void display(int[] a) {
        for (int i=0; i<a.length; i++){
            System.out.print(a[i] + " ");
        }
    }
}

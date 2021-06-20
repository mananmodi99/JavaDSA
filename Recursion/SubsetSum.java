package Recursion;
import java.util.*;
public class SubsetSum {
    public static void SubsetSum(int[] arr, int sum, int count){
        //base
        if(arr.length == 0){
            if(sum == 0){
                count++;
            }
        }
        //recursive
        int ith = arr[0];
        int arrUpdate[] = new int[arr.length-1];
        if(arrUpdate.length>0){
            for(int i = 0; i<arrUpdate.length; i++){
                arrUpdate[i] = arr[i+1];
            }
        }
        SubsetSum(arrUpdate, sum, count);
        SubsetSum(arrUpdate, sum+ith, count);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = 0;
            SubsetSum(arr, 0, count);
            if(count>1)
                System.out.println("Yes");
            else
                System.out.println("No");
            T--;
        }
    }
}

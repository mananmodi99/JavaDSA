package Recursion;

import java.util.Scanner;

public class AllIndicesProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();
        int m = sc.nextInt();
        index(arr,0,n,m);
    }

    private static void index(int[] arr,int i,int n, int m) {
        //base
        if(i>n-1)
            return;
        //recursive
        if(arr[i] == m){
            System.out.print(i+" ");
        }
        index(arr,i+1, n, m);
    }
}

package Recursion;
import java.util.*;

public class TillingPriblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(Ways(n,m));
            T--;
        }
    }
    public static int Ways(int n, int m){
        int count = 0;
        //Base case
        if(n<m)
            return 1;
        if(n==m)
            return 2;
        //recursion
        count = Ways(n-1, m) + Ways(n-m,m);
        return count;
    }
}

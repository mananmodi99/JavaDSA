package Arrays;

import java.util.Scanner;

public class SumofArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int one[] = new int[n];
        for(int i = 0; i<n; i++)
            one[i] = sc.nextInt();
        int m = sc.nextInt();
        int two[] = new int[m];
        for(int i = 0; i<m; i++)
            two[i] = sc.nextInt();
        int hi = Integer.max(n,m);
        int lo = Integer.min(n,m);
        int sum[] = new int[hi];
        for(int i = hi; i>=0; i--){
            for(int j = lo; j>=0; j--){
                sum[i] = one[j] + two[i];
            }
        }
    }
}

package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class HelpRahulSearchProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        //int item = sc.nextInt();
        Arrays.sort(a);
//            for (int val :
//                    a) {
//                System.out.println(val);
//            }
        System.out.println(binarySearch(a, n));
    }
    public static int binarySearch(int[] a, int n){
        Scanner sc = new Scanner(System.in);
        int lo = 0, hi = n-1, ans = 0;
        int item = sc.nextInt();
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(a[mid]<item)
                lo = mid+1;
            else if(a[mid]>item)
                hi = mid-1;
            else
                return mid;
        }
        return -1;
    }
}

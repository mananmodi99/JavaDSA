package Arrays;

import java.util.Scanner;

public class CBScholarship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int lo = 1,hi = n, ans = 0 ;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(mid*x<=m+(n-mid)*y){
                lo = mid+1;
                ans = mid;
            }
            else{
                hi = mid-1;
            }
        }
        System.out.println(ans);
    }
}

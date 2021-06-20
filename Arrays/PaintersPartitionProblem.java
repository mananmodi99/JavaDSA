package Arrays;

import java.util.Scanner;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int l[] = new int[n];
        //length Array
        for(int i=0; i<n; i++) {
            l[i] = sc.nextInt();
        }
        System.out.print(BinarySearch(l,n,k));
    }
    public static int BinarySearch(int l[], int n, int k){
        int sum = 0, ans = 0, curr_max = l[0];//Since Array is not Sorted;
        for(int i=0; i<n; i++) {
            sum += l[i];
            if( l[i]>curr_max ){
                curr_max = l[i];
            }
        }
        int lo = curr_max;
        int hi = sum;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(Condition(l, n, k, mid)){
                //Solution Minimization Based Hence if true then move towards left
                hi = mid - 1;
                ans = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }

    public static boolean Condition(int[] l, int n, int k, int mid) {
        int painter = 1, curr_board = 0;
        for(int i=0; i<n; i++){
            if(curr_board + l[i] > mid){
                curr_board = l[i];
                painter++;
                if(painter > k) {
                    return false;
                }
            } else{
                curr_board += l[i];
            }
        }
        return true;
    }
}

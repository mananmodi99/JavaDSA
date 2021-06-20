package Arrays;
import java.util.*;
//KanadanesAlgo
public class MaxSubArraySum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            System.out.println(KandanesAlgo(arr, n));
            t--;
        }
    }
    public static int KandanesAlgo(int[] a, int n){
        int curr_max = 0, max_till_now = 0;
        for(int i=0; i<n; i++){
            curr_max = Math.max(curr_max+a[i], a[i]);
            max_till_now = Math.max(curr_max, max_till_now);
        }
        return max_till_now;
    }
}


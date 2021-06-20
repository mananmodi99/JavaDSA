import java.util.*;
public class MaxCircularSum {
    public static void main(String args[]) {
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0 && sc.hasNext()){
            int n = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;
            for(int i=0; i<n;i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(MaxSumContigousArr(arr, n));
        }
    }
    public static int MaxSumContigousArr(int[] arr,int n){
        int sum=0;
        for(int i=0; i<n;i++){
            sum += arr[i];
        }
        if(sum == KandanesAlgomin(arr, n))
            return KandanesAlgomax(arr, n);
        return Math.max(KandanesAlgomax(arr, n), sum-KandanesAlgomin(arr, n));
    }
    public static int KandanesAlgomax(int[] arr, int n){
        int max_so_far = 0;
        int curr_max = 0;
        for(int i=0; i<n; i++){
            curr_max = Math.max(arr[i],curr_max+arr[i]);
            max_so_far = Math.max(curr_max, max_so_far);
        }
        return max_so_far;
    }
    public static int KandanesAlgomin(int[] arr, int n){
        int max_so_far = 0;
        int curr_max = 0;
        for(int i=0; i<n; i++){
            curr_max = Math.min(curr_max+arr[i], arr[i]);
            max_so_far = Math.min(curr_max, max_so_far);
        }
        return max_so_far;
    }
}
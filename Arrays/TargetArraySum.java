package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TargetArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i<n; i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int sum = sc.nextInt();
        for(int i=0; i<n-1;i++){
            int lo = i+1;
            int hi = n-1;
            while(lo<hi){
                if(arr[i] + arr[lo] + arr[hi] == sum){
                    System.out.println(arr[i] + "," + arr[lo] + " and " + arr[hi]);
                    lo++;
                    hi--;
                }
                else if(arr[lo] + arr[hi] + arr[i]> sum){
                    hi--;
                }
                else{
                    lo++;
                }
            }
        }
    }
}

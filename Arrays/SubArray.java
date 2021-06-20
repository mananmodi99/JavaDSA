package Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class SubArray {
     public static int[] SubArray(int n){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
         ArrayList<Integer> subsets = new ArrayList<>((n*(n+1))/2);
         for(int i=0; i<n; i++){
             for(int j=i; j<n; j++){
                 int sum = 0;
                 for(int k=i; k<=j; k++) {
                     sum = sum * 10 + arr[k];
                 }
                 subsets.add(sum);
             }
         }

         int subarr[] = new int[subsets.size()];
         for(int i=0; i<subsets.size(); i++){
             subarr[i] = subsets.get(i);
         }
         return subarr;
     }
        // Driver method to test the above function
     public static void main(String[] args)
     {

         System.out.println("All Non-empty Subarrays");
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] SubArray = SubArray(n);
         for (int i:SubArray
              ) {
             System.out.println(i);
         }
     }
}


package Arrays;
//Array must be sorted
//Complexity O(log2(n))
import java.util.*;

public class BinarySearch {
        public static void main(String[] args) {
            int array[] = takeInput();
            //displayInput(array);
            System.out.println(BinarySearch(array));

        }
        public static int[] takeInput(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Size ?");
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i=0; i< arr.length;i++) {
                arr[i] = sc.nextInt();
            }
            return arr;
        }
        public static void displayInput(int[] arr){
            for (int val :
                    arr) {
                System.out.println(val);
            }
        }
        public static int BinarySearch(int[] arr){
            Scanner sc = new Scanner(System.in);
            System.out.println("Search for ?");
            int item = sc.nextInt();
            int lo = 0;
            int hi = arr.length-1;
            while(lo<=hi){
                int mid = (lo+hi)/2;
                if(arr[mid]<item)
                    lo = mid+1;
                else if(arr[mid]>item)
                    hi = mid - 1;
                 else
                    return mid;
                }
            return -1;
        }
}

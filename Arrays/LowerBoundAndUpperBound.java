package Arrays;

import java.util.Scanner;

public class LowerBoundAndUpperBound {
    public static void main(String[] args) {
        int array[] = takeInput();
        //displayInput(array);
        Scanner sc = new Scanner(System.in);
        System.out.println("indexes of?");
        int item = sc.nextInt();
        System.out.println(LowerBound(array,item));
        System.out.println(UpperBound(array,item));

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
    public static int LowerBound(int arr[], int item) {
        int lo = 0;
        int hi = arr.length - 1;
        System.out.println("Enter Item: ");
        int ans = -1;
        while (hi >= lo) {
            int mid = (lo + hi) / 2;
            if (arr[mid] > item)
                hi = mid - 1;
            else if (arr[mid] < item)
                lo = mid + 1;
            else{
                hi = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
    public static int UpperBound(int arr[],int item){
        int lo = 0;
        int hi = arr.length-1;
        int returned = -1;
        while(hi>=lo){
            int mid = (lo+hi)/2;
            if(arr[mid]>item)
                hi = mid-1;
            else if(arr[mid]<item)
                lo = mid+1;
            else{
                lo = mid+1;
                returned = mid;
            }
        }
        return returned;
    }
}

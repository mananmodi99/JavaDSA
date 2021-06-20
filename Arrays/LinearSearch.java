package Arrays;
//TimeComplexity==O(n)
import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {
        int array[] = takeInput();
        displayInput(array);
        System.out.println(LinearSearch(array));
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
        for (int val:
                arr) {
            System.out.println(val);
        }
    }
    public static int LinearSearch(int[] array){
        Scanner sc = new Scanner(System.in);
        System.out.println("Search for ?");
        int item = sc.nextInt();
        for(int i =0; i<array.length; i++){
            if(array[i] == item)
                return i;
        }
        return -1;
    }
}


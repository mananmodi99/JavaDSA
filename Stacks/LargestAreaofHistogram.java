//package Stacks;
//Better solution
import java.util.*;
public class LargestAreaofHistogram {
    public static void main(String[] args) {
        ArrayDeque<Integer> stackLeft = new ArrayDeque<>();
        ArrayDeque<Integer> stackRight = new ArrayDeque<>();
        int arr[] = {6,2,5,4,1,5,6};
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];
        int areas[] = new int[arr.length];
        
        stackLeft.push(arr[0]);
        left[0] = 1;
        
        stackRight.push(arr.length-1);
        right[arr.length-1] = 0;

        for(int i = 1; i<arr.length;i++) {
            //left smaller Element
            while (!stackLeft.isEmpty() && arr[stackLeft.peek()] >= arr[i]) {
                stackLeft.pop();
            }
            left[i] += stackLeft.isEmpty() ? (i+1) : (i - stackLeft.peek());
            stackLeft.push(i);
        }
            //Right() smaller Element
        for(int i = arr.length-2; i>=0; i--) {
            while (!stackRight.isEmpty() && arr[stackRight.peek()] >= arr[i]){
                stackRight.pop();
            }
            right[i] = stackRight.isEmpty() ? arr.length-i-1 : stackRight.peek()-i-1;
            stackRight.push(i);
        }
        for(int i = 0; i<arr.length; i++){
            System.out.print(left[i] + " ");
        }
        System.out.println();
        for(int i = 0; i<arr.length; i++){
            System.out.print(right[i] + " ");
        }
        System.out.println();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++){
            int curr = arr[i];
            curr = (left[i]+right[i])*arr[i];
            max = Math.max(curr, max);
        }
        System.out.println(max);
    }
}
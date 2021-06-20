package Stacks;

import java.util.ArrayDeque;

public class NextSmallerElem {
    public static void main(String[] args) {
        ArrayDeque<Integer> stackRight = new ArrayDeque<>();
        int arr[] = {6,2,5,4,1,5,6};
        int right[] = new int[arr.length];
        stackRight.push(arr.length-1);
        right[arr.length-1] = 0;
        for(int i = arr.length-2; i>=0; i--) {
            while (!stackRight.isEmpty() && arr[stackRight.peek()] >= arr[i]){
                stackRight.pop();
            }
            right[i] = stackRight.isEmpty() ? arr.length-i-1 : stackRight.peek()-i-1;
            stackRight.push(i);
        }
        for(int i: right)
            System.out.print(i+", ");
        System.out.println("End");
    }
}

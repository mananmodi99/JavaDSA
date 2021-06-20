package Stacks;

import java.util.ArrayDeque;

public class NextGreaterElement {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int arr[] = {15,10,18,12,4,6,2,8};
        int nextGreatElem[] = new int[arr.length];
        stack.push(arr[arr.length-1]);
        nextGreatElem[arr.length-1] = -1;
        for(int i = arr.length-2; i>=0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            nextGreatElem[i] = stack.isEmpty()?-1:stack.peek();
            stack.push(arr[i]);
        }
        for(int i: nextGreatElem)
            System.out.print(i+", ");
        System.out.println("End");
    }
}

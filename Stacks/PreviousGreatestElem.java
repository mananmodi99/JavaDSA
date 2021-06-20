package Stacks;

import java.util.ArrayDeque;

public class PreviousGreatestElem {
    public static void main(String[] args) {
        int arr[] = {15,10,18,12,4,6,2,8};
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int prevGreatElem[] = new int[arr.length];
        prevGreatElem[0] = -1;
        stack.push(arr[0]);
        for(int i = 1 ; i<arr.length; i++){
            while(!stack.isEmpty() && stack.peek()<=arr[i])
                stack.pop();
            prevGreatElem[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(arr[i]);
        }
        for(int i: prevGreatElem)
            System.out.print(i+", ");
        System.out.println("End");
    }
}

package Stacks;

import java.util.ArrayDeque;

public class PreviousSmallerElement {
    //span
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int arr[] = {6,2,5,4,1,5,6};
        int prevSmallElem[] = new int[arr.length];
        stack.push(0);
        prevSmallElem[0] = 1;
        for(int i = 0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            prevSmallElem[i] = stack.isEmpty() ? i+1 : i-stack.peek();
            stack.push(i);
        }
        for(int i: prevSmallElem)
            System.out.print(i+", ");
        System.out.println("End");
    }
}

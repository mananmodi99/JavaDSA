package Stacks;

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        int arr[] = {60,10,20,40,35,30,50,70,65};
        int span[] = new int[arr.length];
        span[0] = 1;
        stack.push(0);
        for(int i = 1; i<arr.length; i++){
            while(stack.isEmpty()==false && arr[stack.peek()]<=arr[i])
                stack.pop();
            span[i] = stack.isEmpty()?i+1:i-stack.peek();
            stack.push(i);
        }
        for (int i: span) {
            System.out.print(i+", ");
        }
        System.out.println("END");
    }
}

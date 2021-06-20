package Stacks;

import java.util.ArrayDeque;

public class GetMin {
    //O(1) Time and O(n) space
    ArrayDeque<Integer> stack1 = new ArrayDeque<>();
    ArrayDeque<Integer> minStack = new ArrayDeque<>();
    public void push(int value){
        if(minStack.isEmpty())
            minStack.push(value);
        if(minStack.peek() >= value)
            minStack.push(value);
        stack1.push(value);
    }
    public void pop(){
        if(minStack.peek()==stack1.peek())
            minStack.pop();
        stack1.pop();
    }
    public int getMin(){
        return minStack.peek();
    }
}

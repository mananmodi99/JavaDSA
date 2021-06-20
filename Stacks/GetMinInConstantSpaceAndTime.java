package Stacks;

import java.util.ArrayDeque;

public class GetMinInConstantSpaceAndTime {
    ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
    int min;
    public void push(int value){
        if(stack.isEmpty()){
            min = value;
            stack.push(value);
        }
        else if(value<=min){
            stack.push(value+value-min);
            min = value;
        }
        else
            stack.push(value);
    }
    public int pop() throws Exception {
        int t = stack.pop();
        if(stack.isEmpty())
            throw new Exception("Stack is Empty");
        else if(t<=min){
            int res = min;
            min = 2*min-t;
            return min;
        }
        else
            return t;
    }
    public int getMin(){
        return min;
    }
    public int peek(){
        return (stack.peek()<=min)?min:stack.peek();}
}

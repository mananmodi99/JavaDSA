package Queues;

import java.util.*;

public class StackImplementationUsingQueues {
    Queue<Integer> q = new ArrayDeque<Integer>();
    Queue<Integer> Aux_q = new ArrayDeque<Integer>();

    public void push(int x){
        while(!q.isEmpty()){
            int a = q.poll();
            Aux_q.add(a);
        }
        q.add(x);
        while(!Aux_q.isEmpty()){
            int a = Aux_q.poll();
            q.add(a);
        }
    }
    public int pop(){
        return q.poll();
    }
    public int top(){
        return q.peek();
    }
    public int size() {
        return q.size();
    }

    public static void main(String[] args) {
        StackImplementationUsingQueues s = new StackImplementationUsingQueues();
        s.push(10);
        s.push(5);
        s.push(15);
        s.push(20);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());
    }
}

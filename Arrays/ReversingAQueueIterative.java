package Queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ReversingAQueueIterative {
    public static void ReverseQueue(Queue<Integer> q){
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        while(!q.isEmpty()){
            stack.push(q.remove());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        System.out.println(q);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);
        ReverseQueue(q);
    }
}

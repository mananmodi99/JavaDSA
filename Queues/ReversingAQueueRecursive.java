package Queues;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReversingAQueueRecursive {
    static void RecursiveReverse(Queue<Integer> q){
        //base
        if(q.isEmpty())
            return;
        //recursive
        int x = q.poll();
        RecursiveReverse(q);
        q.add(x);
    }
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
        System.out.println(q);
        RecursiveReverse(q);
        System.out.println(q);
    }
}

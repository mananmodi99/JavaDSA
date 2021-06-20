package Queues;

import java.util.ArrayDeque;
import java.util.Stack;

public class QueuesImplementationUsingStacks {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    ArrayDeque<Integer> aux_stack = new ArrayDeque<>();

    void enQueue(int value) {
        stack.push(value);
    }

    int deQueue() {
        while (!stack.isEmpty()) {
            aux_stack.push(stack.pop());
        }
        int remove = aux_stack.pop();
        while (!aux_stack.isEmpty()) {
            stack.push(aux_stack.pop());
        }
        return remove;
    }

    int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        QueuesImplementationUsingStacks q = new QueuesImplementationUsingStacks();
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        System.out.println("Removed Element is: " + q.deQueue());
        System.out.println("Current Size is: " + q.size());
        System.out.println("Removed Element is: " + q.deQueue());
        System.out.println("Current Size is: " + q.size());
        System.out.println("Removed Element is: " + q.deQueue());
        System.out.println("Current Size is: " + q.size());
    }
}

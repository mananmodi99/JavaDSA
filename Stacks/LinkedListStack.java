package Stacks;

public class LinkedListStack {
    Node head;
    int size;
    class Node{
        int data;
        Node next;
    }
    public void push(int value){
        Node nn = new Node();
        if(this.size == 0){this.head = nn;}
        nn.data = value;
        nn.next = this.head;
        this.head = nn;
        this.size++;
    }
    public int pop() throws Exception{
        if(this.isEmpty())
            throw new Exception("Stack Empty");
        this.head = this.head.next;
        this.size--;
        return 0;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public int peek(){
        return this.head.data;
    }
    public int size(){
        return this.size;
    }
}

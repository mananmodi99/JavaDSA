package Queues;

public class QueuesLinkedList {
    class Node{
        int data;
        Node next;
    }
    Node head;
    Node tail;
    int size;

    public boolean isEmpty(){
        return this.size==0;
    }
    public void enqueue(int x){
        Node nn = new Node();
        nn.data = x;
        if(isEmpty()){
            nn.next = null;
            this.head = nn;
            this.tail = nn;
        }
        else
            this.tail.next = nn;
        size++;
    }
    public void dequeue(){
        if(size == 0){
            System.out.println("Queue is empty");
        }
        if(size == 1){
            head = null;
            tail = null;
        }
        head = head.next;
        size--;
    }
    public int getFront(){
        return this.head.data;
    }
    public int getRear(){
        return this.tail.data;
    }
}

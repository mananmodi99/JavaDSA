package Queues;

public class QueuesCircularArray {
    //circular Array Approach
    //rear can also be calculated as (front+size-1)%capacity;
    int front , rear, size, capacity;
    int data[];
    public QueuesCircularArray(int size) {
        front = 0;
        rear = this.size-1;
        capacity = size;
        this.size = 0;
        data = new int[size];
    }
    public void enqueue(int value){
        if(!this.isFull()){
            rear = (rear+1)%capacity;
            this.data[rear] = value;
            size--;
        }
    }
    public void dequeue(){
        if(!isEmpty()){
            data[front] = 0;
            front = (front+1)%capacity;
            size--;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return this.size == this.capacity;
    }
    public void display(){
        //just to display not mandatory
        System.out.print("| ");
        for(int i = 0; i< data.length; i++){
            System.out.print(data[i]+" | ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        QueuesCircularArray queue = new QueuesCircularArray(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        queue.enqueue(40);
        queue.display();
    }
}

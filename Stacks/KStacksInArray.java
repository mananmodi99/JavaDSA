package Stacks;

public class KStacksInArray {
    int arr[];
    int top[];
    int next[];
    int nextTop;
    public KStacksInArray(int size, int ns){
        arr = new int[size];
        next = new int[size];
        top = new int[ns];
        for(int i = 0; i<next.length; i++)
            next[i] = i+1;
        next[next.length-1] = -1;
        for(int i = 0; i<top.length;i++)
            top[i] = -1;
        int nextTop = 0;
    }
    public void push(int value, int sn){
        int i = nextTop;
        nextTop = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = value;
    }
    public int pop(int sn){
        int i = top[sn];
        top[sn] = next[i];
        next[i] = nextTop;
        nextTop = i;
        return 0;
    }
    public void display(){
        System.out.println();
        for(int i = 0; i< arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

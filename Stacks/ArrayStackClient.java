package Stacks;

public class ArrayStackClient {
    public static void main(String[] args) throws Exception {
        MyStack s = new MyStack(10);
        s.push(10);
        s.push(20);
        System.out.println(s.pop());
        s.push(30);
        System.out.println(s.isEmpty());
        System.out.println(s.size());
    }
}

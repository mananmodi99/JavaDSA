package Stacks;

public class KstacksClient {
    public static void main(String[] args) {
        KStacksInArray stack = new KStacksInArray(10,2);
        stack.push(20,0);
        stack.push(30,0);
        stack.pop(0);
        stack.display();;
        stack.push(200,1);
        stack.push(40,0);
        stack.push(300,1);
        //stack.push(1000,2);
        stack.display();
        stack.pop(0);
        stack.pop(1);
        //stack.pop(2);
        stack.display();
    }
}

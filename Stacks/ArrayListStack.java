package Stacks;
import java.util.*;

public class ArrayListStack {
    ArrayList<Integer> data = new ArrayList<>();
    int top = -1;
    public void push(int val){
        data.add(val);
    }
    public int pop(){
        int temp = data.get(this.top);
        data.remove(this.top);
        return temp;
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public int peek(){
        return data.indexOf(data.size()-1);
    }
    public int size(){
        return data.size();
    }
}

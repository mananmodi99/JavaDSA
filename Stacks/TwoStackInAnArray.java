package Stacks;

public class TwoStackInAnArray {
    int arr[];int size;
    int top1, top2;
    public TwoStackInAnArray(int size){
        int arr[] = new int[size];
        top1 = -1;
        top2 = this.size;
    }
    public void push1(int value) throws Exception{
        if(this.top1>=this.top2-1)
            throw new Exception("Stack 1 Overflow");
        this.top1++;
        arr[this.top1] = value;
    }
    public void push2(int value) throws Exception{
        if(this.top1<this.top2-1)
            throw new Exception("Stack 2 Overflow");
        this.top2--;
        arr[this.top2] = value;
    }
    public int pop1() throws Exception{
        if(this.top1 == -1)
            throw new Exception("Stack 1 Underflow");
        int value = this.arr[this.top1];
        this.top1--;
        return value;
    }
    public int pop2() throws Exception{
        if(this.top2 == this.size)
            throw new Exception("Stack 2 Underflow");
        int value = this.arr[this.top2];
        this.top2++;
        return value;
    }
    public int size1(){
        return this.top1+1;
    }
    public int size2(){
        return (this.size-this.top2);
    }
}


package Stacks;
//Simple Stack
class MyStack{
    public int[] data;
    int size;
    int top;
    public MyStack(int size){
        this.size = size;
        this.data = new int[this.size];
        this.top = -1;
    }
    public void push(int value) throws Exception{
        if(this.top < this.size){
            this.top++;
            this.data[this.top] = value;
        }
        else
            throw new Exception("Stack is full");
    }
    public int peek() throws Exception{
        if(this.top==-1)
            throw new Exception("Fill Stack first");
        return this.data[this.top];
    }
    public int pop() throws Exception{
        if(this.size<=0){
            throw new Exception("Empty Stack");
        }
        int temp = data[this.top];
        data[this.top] = 0;
        this.top--;
        return temp;
    }
    public int size(){
        return this.top+1;
    }
    public boolean isEmpty(){
        return this.top == -1;
    }
    public int getMin(){
        int getMin = Integer.MIN_VALUE;
        for(int i = 0; i<this.data.length; i++){
            getMin = Math.min(this.data[i], getMin);
        }
        return getMin;
    }
}


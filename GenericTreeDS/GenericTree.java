package GenericTreeDS;

import java.util.ArrayList;

import java.util.*;

public class GenericTree {

    Scanner sc = new Scanner(System.in);

    private class node {
        int data;
        ArrayList<node> children = new ArrayList<>();
    }
    private node root;


//-----------------------------------------------------------------------------

    //constructor
    GenericTree() {
        root = construct(null, -1);
    }


//-----------------------------------------------------------------------------

    //this represents ith children of parent node
    //it creates a child node and returns its address
    private node construct(node parent, int ith) {
        if(parent == null){
            System.out.println("Enter the data for root node");
        } else {
            System.out.println("Enter the data for "+ith+" child of "+parent.data);
        }
        int item = sc.nextInt();
        node nn = new node();
        nn.data = item;
        System.out.println("Enter the number of children for "+nn.data);
        //noc=number of children
        int noc = sc.nextInt();
        for (int j = 0; j < noc; j++) {
            node child = construct(nn, j);
            nn.children.add(child);
        }
        return nn;
    }

//-----------------------------------------------------------------------------

    //display for user
    public void display(){
        display(root);
    }



    //display
    private void display(node nn){

        String s = "";
        s += nn.data + "--->";
        for(node x : nn.children){
            s += x.data + " ";
        }
        s += ".";
        System.out.println(s);
        for(node x: nn.children){
            display(x);
        }

    }
    //-----------------------------------------------------------------------------
    public int size(){
        return size(root);
    }

    private int size(node nn){
        int total_count = 1;

        for(int i = 0; i<nn.children.size(); i++){
            total_count += size(nn.children.get(i));
        }
        return total_count;
    }

//-----------------------------------------------------------------------------

    public int maximum(){
        return maximum(root);
    }

    private int maximum(node nn){
        int max = nn.data;

        for(node x: nn.children){
            max = Math.max(max,maximum(x));
        }

        return max;
    }


//-----------------------------------------------------------------------------

    public boolean find(int x){
        return find(root,x);
    }

    private boolean find(node nn, int x){
        boolean flag = (nn.data==x);
        if(flag)
            return true;
        for(node z: nn.children){
            flag = flag||(find(z,x));
            if(flag)
                return true;
        }
        return flag;
    }
//-----------------------------------------------------------------------------

    public int height(){
        return height(root);
    }

    private int height(node nn){
        int count = -1;

        for(node x:nn.children){
            count = Math.max(count,height(x));
        }
        return count+1;
    }

//-----------------------------------------------------------------------------
}

class client{
    public static void main(String[] args){
        GenericTree gt = new GenericTree();
        gt.display();
        System.out.println(gt.size());
        System.out.println(gt.maximum());
        System.out.println(gt.find(20));
        System.out.println(gt.height());
    }
}

//-----------------------------------------------------------------------------

//input: 10 3 20 2 50 0 60 0 30 0 40 1 70 0

import java.util.*;
//10 true 20 true 40 false false true 50 false false true 30 false true 60 false false
//10 true 20 true 40 true 70 true 90 true 110 false false false false false true 50 false true 80 false true 100 false true 120 false false true 30 false true 60 false false
public class BinaryTree {
    Scanner sc = new Scanner(System.in);
    private class Node{
    	int data;
    	Node left;
    	Node right;
    }
    private Node root;
    public void construct(){
    	root = construct(null,false);
    }
    public Node construct(Node parent, boolean ilc){
    	if(parent == null){
    		System.out.println("Enter the data for Root Node: ");
    	}
    	else{
    		if(ilc)
    			System.out.println("Enter the data for Left Node : ");
    		else
    			System.out.println("Enter the data for Right Node: ");
    	}
    	int item = sc.nextInt();
    	Node nn = new Node();
        nn.data = item;
    	//Working on their child now:
    	System.out.println("Does this node " + nn.data + " have any Left Child? ");
    	boolean hlc = sc.nextBoolean();
    	if(hlc){
    		nn.left = construct(nn, true);
        }

    	System.out.println("Does this node " + nn.data + "  have any Right Child? ");
    	
        boolean hrc = sc.nextBoolean();
    	
        if(hrc){
    		nn.right = construct(nn, false);
        }
    	
        return nn;
    
    }
    public void display(){
    	display(root);
    }
    private void display(Node node) {

        if (node == null) {
            return;
        }

        String str = "";

        if (node.left == null) {
            str += ".";
        } else {
            str += node.left.data;
        }

        str += " -> " + node.data + " <- ";

        if (node.right == null) {
            str += ".";
        } else {
            str += node.right.data;
        }

        System.out.println(str);

        display(node.left);
        display(node.right);

    }
    public int size(){
        return size(root);
    }
    private int size(Node node){
        int size = 0;
        if(node.left != null){
            size += size(node.left);
        }
        if(node.right != null){
            size += size(node.right);
        }
        return size+1;
    }
    public int max(){
        return max(root);
    }
    private int max(Node node){
        if(node == null) return 0;
        int max = node.data;
        max = Math.max(max(node.left), max);
        max = Math.max(max(node.right), max);
        return max;
    }
    public boolean find(int toFind){
        return find(root, toFind);
    }
    private boolean find(Node curr_node, int item){
        if(curr_node == null) return false;
        if(curr_node.data == item) 
            return true;
        if(find(curr_node.left, item)) return true;
        if(find(curr_node.right, item)) return true;
        return false;
    }
    public int height(){
        return height(root);
    }
    private int height(Node curr_node){
        if(curr_node == null) return -1;
        int max_height = -1;
        max_height = Math.max(height(curr_node.left), max_height);
        max_height = Math.max(height(curr_node.right), max_height);
        return max_height+1;
    }
    public int diameter(){
        return diameter(root);
    }
    public int diameter(Node curr_root){
        if(curr_root == null)
            return 0;
        int curr_node_dia = this.height(curr_root.left) + this.height(curr_root.right) + 2;

        return Math.max(curr_node_dia,Math.max(diameter(curr_root.left), diameter(curr_root.right)));
    }
    public static void main(String[] args){
        BinaryTree bt = new BinaryTree();
        bt.construct();
        bt.display();
        System.out.println("The size of BT is: " + bt.size());
        System.out.println("The Max elem of BT is: " + bt.max());
        System.out.println("The item 40 is present or not: " + bt.find(40));
        System.out.println("The height of BT is: " + bt.height());
        System.out.println("The diameter of BT is: " + bt.diameter());
    }
}
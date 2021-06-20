import java.util.*;

public class Swap2WrongNodes {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int value){
			data = value;
		}
	}
    static Node prev = null;
	static Node fix1 = null;
	static Node fix2 = null;
	static void fixABST(Node root){
		if(root == null) return;
		fixABST(root.left);
		if(prev!=null  && prev.data>root.data){
			if(fix1 == null)
				fix1 = prev;
			fix2 = root;
		}
		prev = root;
		fixABST(root.right);
		
	}
	static void inorder(Node root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	public static void main(String[] args) {
		Swap2WrongNodes bst = new Swap2WrongNodes();
		Node root = new Node(18);  
        root.left = new Node(60);  
        root.right = new Node(70);  
        root.left.left = new Node(4);  
        root.right.left = new Node(8);
        root.right.right = new Node(80);
        inorder(root);
        fixABST(root);
        System.out.println();
        if(fix1!=null && fix2!=null){
		int temp = fix1.data;
		fix1.data = fix2.data;
		fix2.data = temp;}
        inorder(root);
	}
}


	
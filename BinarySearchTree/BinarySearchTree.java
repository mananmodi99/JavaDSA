package BinarySearchTree;//package BinarySearchTreeDS;
import java.util.*;

public class BinarySearchTree {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int value){
			data = value;
		}
	}
	static void display(Node node){
		if(node == null) return;
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
	static boolean search(int value, Node root){
		if(root == null) return false;
		if(root.data == value) return true;
		if(root.data > value) return search(value, root.left);
		else return search(value, root.right);	
	}
	static boolean searchIterative(int value, Node root){
		while(root!=null){
			if(root.data>value) root = root.left;
			if(root.data<value) root = root.right;
			if(root.data == value) return true;
		}
		return false;
	}
	static Node insert(int value, Node root){
		if(root == null){
			Node nn = new Node(value);
			return nn;
		}
		if(value>root.data)
			root.right = insert(value, root.right);
		else if(value<root.data)
			root.left = insert(value, root.left);
		return root; 
	}
	static Node InsertIterative(int value, Node root){
		Node nn = new Node(value);
		Node curr = root;
		Node prev = null;
		while(curr!=null){
			prev = curr;
			if(curr.data<value)
				curr = curr.right;
			if(curr.data>value)
				curr = curr.left;
			if(curr.data == value)
				return root;
		}
		//now linking
		if(prev == null)
			return nn;
		if(prev.data>value)
			prev.left = nn;
		if(prev.data<value)
			prev.right = nn;
		return root;
	}
	static void inorder(Node root){
		if(root == null) return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	static Node delete(int value, Node root){
		if(root == null)
			return null;
		if(root.data > value)
			root.left = delete(value, root.left);
		if(root.data < value)
			root.right = delete(value, root.right);
		else{
			if(root.left == null) return root.right; //Case 1 and 2
			if(root.right == null) return root.left;//Case 2
			else{ //Case 3
				Node greatSucc = getGreatSucc(root);
				root.data = greatSucc.data;
				root.right = delete(greatSucc.data, root.right);
			}			
		}
		return root;
	}
	static Node getGreatSucc(Node root){
		Node curr = root.right;
		while(curr!=null && curr.left!=null)
			curr = curr.left;
		return curr;
	}
	static int floor(Node root, int value){
		Node curr = root;
		int curr_floor = root.data;
		while(curr!=null){
			if(curr.data == value){
				return curr.data;
			}
			else if(curr!= null && curr.data>value){
				//curr_floor = Math.min(curr_floor, curr.data);
				curr = curr.left;
			}
			else{
				curr_floor = curr.data;
				curr = curr.right;
			}
		}
		return curr_floor;
	}
	static int ceil(Node root, int value){
		Node curr = root;
		int curr_ceil = root.data;
		while(curr!=null){
			if(curr.data == value){
				return value;
			}
			else if(curr.data>value){
				curr_ceil = curr.data;
				curr = curr.left;
			}
			else{
				//curr_ceil = Math.min(curr_ceil, curr.data);
				curr = curr.right;
			}
		}
		return curr_ceil;
	}
	static int maxVal(Node root){
		if(root == null) return Integer.MIN_VALUE;
		else
		return Math.max(root.data, Math.max(maxVal(root.left), maxVal(root.right)));
	}
	static int minVal(Node root){
		if(root == null) return Integer.MAX_VALUE;
		else
		return Math.min(root.data, Math.min(minVal(root.left), minVal(root.right)));
	}
	static boolean isBST(Node root){//O(n2)
		if(root == null) return true;
		boolean isBST = false;
		if(root.data>maxVal(root.left) && root.data<minVal(root.right))
			return isBST(root.left) && isBST(root.right);
		else
			return false;

	}
	static boolean isBSTM2(Node root, int lowerBound, int upperBound){
		if(root == null) return true;
		if(root.data>lowerBound && root.data<upperBound)
			return isBSTM2(root.left, lowerBound, root.data) && isBSTM2(root.right, root.data, upperBound);
		return false;
	}
	static int prev = Integer.MIN_VALUE;
	static boolean isBSTM3(Node root){
		if(root == null) return true;
		if(isBSTM3(root.left) == false) return false;
		if(root.data<=prev) return false;
		prev = root.data;
		return isBSTM3(root.right);
	}
	ArrayList<Integer> arr = new ArrayList<>();
	boolean PairSum(Node root, int sum){//O(n2) chutiyaap
		if(root == null) return false;
		PairSum(root.left, sum);
		for(int i= 0; i<arr.size(); i++){
			if(arr.get(i)+root.data == sum){
				return true;
			}
		}
		arr.add(root.data);
		return PairSum(root.right, sum);
	}
	static void InorderArray(Node root, ArrayList<Integer> arr2){
		if(root == null) return;
		InorderArray(root.left, arr2);
		arr2.add(root.data);
		InorderArray(root.right, arr2);
		//System.out.println(arr2);
	}
	boolean PairSum(int sum, ArrayList<Integer> arr2){//2 pointer Approach
		int left = 0;
		int right = arr2.size()-1;
		while(left<=right){
			if(arr2.get(left) + arr2.get(right) == sum)
				return true;
			else if(arr2.get(left) + arr2.get(right) < sum) left++;
			else right--;
		}
		return false;
	}
	boolean PairSum(Node root,int sum, TreeSet<Integer> t){
		if(root == null) return false;
		if(PairSum(root.left, sum, t)==true) return true;
		if(t.contains(sum-root.data)){
			return true;
		}
		t.add(root.data);
		return PairSum(root.right, sum, t);
	}
	static void VerticalSumOfABT(Node root, int horizontalDist, TreeMap<Integer, Integer> map){
		if(root == null) return;
		VerticalSumOfABT(root.left, horizontalDist-1, map);
		int Vsum = (map.get(horizontalDist) == null)?0:map.get(horizontalDist);//denotes Vertical sum
		map.put(horizontalDist, Vsum+root.data);
		VerticalSumOfABT(root.right, horizontalDist+1, map);
	}
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		Node root = bst.insert(18, null);
		root.left = new Node(8);  
        root.right = new Node(30);  
        root.right.left = new Node(20);  
        root.right.right = new Node(35); 
		// bst.insert(30, root);
		// bst.insert(20, root);
		// bst.insert(70, root);
		// bst.insert(40, root);
		// bst.insert(60, root);
		// bst.insert(55, root);
		// bst.insert(80, root);
		// bst.insert(65, root);
		bst.inorder(root);
		//root = bst.delete(10, root);
		System.out.println();
		//bst.inorder(root);
		bst.display(root);
		System.out.println(bst.floor(root, 100));
		System.out.println(bst.ceil(root, 90000));
		System.out.println(bst.isBST(root));
		System.out.println(bst.minVal(root));
		System.out.println(bst.isBSTM2(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
		System.out.println(bst.isBSTM3(root));
		System.out.println(bst.PairSum(root, 54));
		//2 pointer Approach
		ArrayList<Integer> arr = new ArrayList<>();
		bst.InorderArray(root, arr);
		System.out.println(arr);
		System.out.println(bst.PairSum(78, arr));
		System.out.println();
		System.out.println(bst.PairSum(root, 50, new TreeSet<Integer>()));	
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		VerticalSumOfABT(root, 0, map);
		for(Map.Entry<Integer, Integer> e : map.entrySet())
			System.out.println(e);
	}
}
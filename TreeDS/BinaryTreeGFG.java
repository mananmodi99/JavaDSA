package TreeDS;

import java.util.*;

public class BinaryTreeGFG {
	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
		}
	}
	
	Node ConstructBT() {
		//Creation of BT:
		Scanner sc = new Scanner(System.in);
		// Node root = new Node(10);
		// root.left = new Node(20);
		// //root.right = new Node(60);
		// root.left.left = new Node(30);
		// root.left.left.right = new Node(50);
		// root.left.left.left = new Node(40);
		// root.left.left.left.left = new Node(60);
		// root.left.right = new Node(80);
		// root.left.right.right = new Node(90);
		// root.left.right.right.right = new Node(18);
		Node root=new Node(10);
    	root.left=new Node(20);
    	root.right=new Node(30);
    	root.right.left=new Node(40);
    	root.right.right=new Node(50);
		//root.left.right.right.left = new Node(1000);
		return root;
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
	static void InOrder(Node root){
		if(root == null) return;
		InOrder(root.left);
		System.out.print(root.data + " ");
		InOrder(root.right);
	}
	static void InOrderIterative(Node root){
		Stack<Node> s = new Stack<>();
		Node curr = root;
		while(curr != null || !s.isEmpty()){
			while(curr != null){
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}
	static void PreOrder(Node root){
		if(root == null) return;
		System.out.print(root.data + " ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	static void PreOrderIterative(Node root){
		Stack<Node> s = new Stack<>();
		//Node curr = root;
		s.push(root);
		while(!s.isEmpty()){
			Node curr = s.pop();
			System.out.print(curr.data + " ");
			if(curr.right != null) s.push(curr.right);//just pushing right first so that left remains at top;
			if(curr.left != null) s.push(curr.left);
		}
	}
	static void PreOrderIterativeOptimizedSpace(Node root){
		Stack<Node> s = new Stack<>();
		s.push(root);
		Node curr = root;
		while(!s.isEmpty()){
			while(curr!=null){
				System.out.print(curr.data + " ");
				if(curr.right!=null)
					s.push(curr.right);
				curr = curr.left;
			}
			curr = s.pop();
		}
	}
	static void PostOrder(Node root){
		if(root == null) return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data + " ");
	}
	static void LevelOrder(Node root){//VIMP//Non Recursive - Recursive doesn't work here
		if(root == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			Node curr = q.poll();
			System.out.print(curr.data + " ");
			if(curr.left != null)
				q.add(curr.left);
			if(curr.right != null)
				q.add(curr.right);
		}
	}
	static void LevelOrderLineByLine(Node node){
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		q.add(null);
		while(q.size()>1){
			Node temp = q.remove();
			if(temp != null) { 
				System.out.print(temp.data + " ");
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
			if(temp == null) {
				q.add(null);
				System.out.println();
			}
		}
	}
	static void LevelOrderLineByLineM2(Node root){
		if(root==null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
			int size_of_level = q.size();
			for(int i = 0; i<size_of_level; i++){
			Node temp = q.poll();
			System.out.print(temp.data + " ");
			if(temp.left!=null) q.add(temp.left);
			if(temp.right!=null) q.add(temp.right);
			}
			System.out.println();
		}
	}
	static int height_EdgeWise(Node root){
		int max_height = -1;
		if(root == null)
			return max_height;
		max_height = Math.max(Math.max(height_EdgeWise(root.left), height_EdgeWise(root.right)), max_height);
		return max_height+1; 
	}
	static int height_NodeWise(Node root){
		int max_height = 0;
		if(root == null)
			return max_height;
		max_height = Math.max(Math.max(height_NodeWise(root.left), height_NodeWise(root.right)), max_height);
		return max_height+1; 
	}
	static void nodeAtDistK(Node node, int k) throws Exception{
		
		if(node == null)
			return;
		if(k == 0)	
			System.out.print(node.data + "  ");
		nodeAtDistK(node.left, k-1);
		nodeAtDistK(node.right, k-1);

	}
	static int size(Node node){
		if(node == null) return 0;
		int sum = 1;//curr node
		sum += size(node.left);
		sum += size(node.right);
		return sum;

	}
	static int max(Node node){
		if(node == null) return Integer.MIN_VALUE;
		int max_elem = node.data;
		max_elem = Math.max(Math.max(max(node.left), max(node.right)), max_elem);
		return max_elem;
	}
	static void leftViewIterative(Node node){
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		//System.out.print(node.data + " ");
		q.add(node);
		while(!q.isEmpty()){
			int size_of_level = q.size();
			for(int i= 0; i<size_of_level; i++){
				Node temp = q.poll();
				if(i==0) System.out.print(temp.data + " ");
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
			
		}
	}
	static int max_level = 0;
	static void leftViewRecursive(Node root){
		leftViewRecursive(root, 1);
	}
	static void leftViewRecursive(Node node, int level){
		if(node == null) return;
		if(level>max_level){
			System.out.print(node.data + " ");
			max_level = level;
		}
		leftViewRecursive(node.left, level+1);
		leftViewRecursive(node.right, level+1);
	}
	static boolean childrenSumProperty(Node node){
		if(node == null) return true;
		if(node.left == null && node.right == null)return true;
		int sum_check = 0;
		if(node.left!=null)
			sum_check += node.left.data;
		if(node.right!=null)
			sum_check += node.right.data;
		
		return (node.data == sum_check && childrenSumProperty(node.left) && childrenSumProperty(node.right));
	}
	static boolean isBalancedNaive(Node node){//O(n2)
		if(node == null) return true;
		int leftHeight = height_EdgeWise(node.left);
		int rightHeight = height_EdgeWise(node.right);
		//selfWork and Smaller prob
		return ((Math.abs(leftHeight-rightHeight)<=1) && isBalancedNaive(node.left) && isBalancedNaive(node.right));
	}
	
	static int isBalancedEfficient(Node node){//V Nice Approach
		if(node == null) return 0;
		int lh = isBalancedEfficient(node.left);
		if(lh == -1) return -1;
		int rh = isBalancedEfficient(node.right);
		if(rh == -1) return -1;
		if(Math.abs(lh-rh)>1) return -1;
		return Math.max(lh,rh)+1;
	}
	static int MaxWidth(Node node){
		if(node == null) return 0;
		Queue<Node> q = new ArrayDeque<>();
		q.add(node);
		int max_size = 0;
		while(!q.isEmpty()){
			max_size = Math.max(q.size(), max_size);
			int size = q.size();
			for(int i = 0; i<size; i++){
				Node temp = q.poll();
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
		}
		return max_size;
	}
	static Node prev = null;
	static Node BT_to_DLL(Node root){
		if(root == null) return root;
		Node head = BT_to_DLL(root.left);
		if(prev == null) head = root;
		else{
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		BT_to_DLL(root.right);
		return head;
	}
	static void spiralPrint(Node node){
		if(node == null) return;
		Queue<Node> q = new LinkedList<>();
		Stack<Integer> s = new Stack<>();
		q.add(node);
		boolean rToL = false;
		while(!q.isEmpty()){
			int count = q.size();
			for(int i = 0; i<count;i++){
				Node temp = q.poll();
				if(rToL)
					s.push(temp.data);
				else
					System.out.print(temp.data + " ");
				if(temp.left!=null) q.add(temp.left);
				if(temp.right!=null) q.add(temp.right);
			}
			if(rToL){
				while(!s.isEmpty())
					System.out.print(s.pop()+" ");
			}
			rToL = !rToL;
			System.out.println();
		}
	}
	static void spiralPrintM2(Node node){
		if(node == null) return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(node);
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				Node temp = s1.pop();
				System.out.print(temp.data + " ");
				if(temp.left!=null) s2.push(temp.left);
				if(temp.right!=null) s2.push(temp.right);
			}
			System.out.println();
			while(!s2.isEmpty()){
				Node temp = s2.pop();
				System.out.print(temp.data + " ");
				if(temp.right!=null) s1.push(temp.right);
				if(temp.left!=null) s1.push(temp.left);
			}
			System.out.println();
		}	
	}
	static int Diameter(Node node){
		//ht of rt tree + ht of lt + 2;
		if(node == null) return 0;
		int dia = 0;
		dia += height_NodeWise(node.left);
		dia += height_NodeWise(node.right);

		return Math.max(Math.max(Diameter(node.left),Diameter(node.right)), dia+1);
	}
	static int dia = 0;
	static int diameterinHeightFuncItself(Node node){
		if(node == null) return 0;
		int max_lh = 0;
		int max_rh = 0;
		max_lh = diameterinHeightFuncItself(node.left);
		max_rh = diameterinHeightFuncItself(node.right);
		dia = Math.max(max_lh+max_rh+1, dia);
		return Math.max(max_lh, max_rh)+1;
	}
	static boolean findPath(Node root, ArrayList<Node> path, int n){
		if(root == null) return false;
		path.add(root);
		if(root.data == n) return true;
		if(findPath(root.left, path, n) || findPath(root.right, path, n))
			return true;
		path.remove(path.size()-1);
		return false;
	}
	static Node LCA(Node root, int n1, int n2){
		ArrayList<Node> path1 = new ArrayList<>();
		ArrayList<Node> path2 = new ArrayList<>();
		findPath(root, path1, n1);
		findPath(root, path2, n2);
			//return null;
		for(int i = 0; i<Math.min(path1.size()-1,path2.size()-1); i++){
			if(path1.get(i+1) != path2.get(i+1)){
				return path1.get(i);
			}
		}
		return null;	
	}
	static Node LCAM2(Node root, int n1, int n2){
		//Cases wise
		if(root == null) return null;//case 4
		if(root.data == n1 || root.data == n2)
			return root;//CASE 1
		Node lca_l = LCAM2(root.left, n1, n2);
		Node lca_r = LCAM2(root.right, n1, n2);
		if(lca_l!=null && lca_r != null)//case 2
			return root;
		else{//case 3
			if(lca_l != null)
				return lca_l;
			else
				return lca_r;
		}
	} 
	static void MaxDistanceFromAnyNode(Node node){
		//Basically Diameter from given node nikalna hai
		//Skipped
	} 
	static int CountNoOfNodes(Node node){
		if(node == null) return 0;
		int count = 0;
		count += CountNoOfNodes(node.left);
		count += CountNoOfNodes(node.right);
		return count+1;
	}
	
	static int CountNodesEfficient(Node root){
		int lh = 0;
		int rh = 0;
		Node temp = root;
		while(temp!=null){
			lh++;
			temp = temp.left;
		}
		temp = root;
		while(temp!=null){
			rh++;
			temp = temp.right;
		}
		if(lh == rh)
			return (int)Math.pow(2, lh) - 1;
		else
			return CountNodesEfficient(root.left)+CountNodesEfficient(root.right)+1;
	}
	static void serializeTreeToArray(Node root, ArrayList<Integer> arr){
		//Assuming Pre Order
		if(root == null){ arr.add(-1);return;}
		arr.add(root.data);
		serializeTreeToArray(root.left, arr);
		serializeTreeToArray(root.right, arr);
	}
	static Node deserializeArrayToTree(ArrayList<Integer> arr){
		if(arr.isEmpty()) return null;
		if(arr.get(0) == -1) return null;
		Node root = new Node(arr.get(0));
		arr.remove(0);
		root.left = deserializeArrayToTree(arr);
		arr.remove(0);
		root.right = deserializeArrayToTree(arr);
		return root;
	}

	public static void main(String[] args) throws Exception{
		BinaryTreeGFG bt = new BinaryTreeGFG();
		Node root = bt.ConstructBT();
		System.out.println("---------------------Display-------------------------");
		bt.display(root);
		System.out.println("---------------------InOrder-------------------------");
		bt.InOrder(root);
		System.out.println();
		InOrderIterative(root);
		System.out.println();
		System.out.println("---------------------PreOrder-------------------------");
		bt.PreOrder(root);
		System.out.println();
		PreOrderIterative(root);
		System.out.println();
		PreOrderIterativeOptimizedSpace(root);
		System.out.println();
		System.out.println("---------------------PostOrder-------------------------");
		bt.PostOrder(root);
		System.out.println();

		System.out.println();
		System.out.println("---------------------Level Order-------------------------");
		bt.LevelOrder(root);
		System.out.println();
		System.out.println("---------------------Level Order - LINE BY LINE-------------------------");
		bt.LevelOrderLineByLine(root);
		System.out.println();
		System.out.println("---------------------Level Order - LINE BY LINE - Method 2-------------------------");
		bt.LevelOrderLineByLineM2(root);
		System.out.println();
		System.out.println("---------------------height_EdgeWise-------------------------");
		System.out.println(bt.height_EdgeWise(root));	
		System.out.println("---------------------height_NodeWise-------------------------");
		System.out.println(bt.height_NodeWise(root));	
		System.out.println("---------------------K Node distant from root-------------------------");
		bt.nodeAtDistK(root,3);
		System.out.println();
		System.out.println("---------------------SIZE-----------------------------------------");
		System.out.println(bt.size(root));
		System.out.println();
		System.out.println("---------------------MAX ELEMENT-----------------------------------------");
		System.out.println(bt.max(root));
		System.out.println("---------------------LEFT VIEW - Iterative-----------------------------------------");
		bt.leftViewIterative(root);
		System.out.println();
		System.out.println("---------------------LEFT VIEW - Recursive-----------------------------------------");
		bt.leftViewRecursive(root);
		System.out.println();
		System.out.println("---------------------childrenSumProperty Verification-----------------------------------------");
		System.out.println(childrenSumProperty(root));
		System.out.println();
		System.out.println("---------------------Naive Method : isBalanced Tree?-----------------------------------------");
		System.out.println(isBalancedNaive(root));
		System.out.println();
		System.out.println("---------------------Efficient Method : isBalanced Tree?-----------------------------------------");
		System.out.println((isBalancedEfficient(root)>=0) ? "True":"False");
		System.out.println("");
		System.out.println("---------------------Max Width of BT-----------------------------------------");
		System.out.println(MaxWidth(root));
		System.out.println();
		//System.out.println(BT_to_DLL(root).data);
		System.out.println("---------------------Spiral Printing-----------------------------------------");
		spiralPrint(root);
		System.out.println();
		System.out.println("---------------------Spiral Printing M2 -----------------------------------------");
		spiralPrintM2(root);
		System.out.println();
		System.out.println("---------------------Diameter -----------------------------------------");
		System.out.println(Diameter(root));
		diameterinHeightFuncItself(root);
		System.out.println(dia);
		System.out.println();
		System.out.println("---------------------Least Common Ancestor -----------------------------------------");
		if(LCA(root, 40, 50) != null)
			System.out.println(LCA(root, 40, 50).data);
		else
			System.out.println("DNE - either n1 or n2 or maybe both");
		System.out.println(LCAM2(root, 40, 50).data);
		System.out.println();
		System.out.println("---------------------Count of Nodes-----------------------------------------");
		System.out.println(CountNoOfNodes(root));
		System.out.println(CountNodesEfficient(root));
		System.out.println();
		System.out.println("---------------------serialize Tree To ArrayList-----------------------------------------");
		ArrayList<Integer> serialized = new ArrayList<>();
		serializeTreeToArray(root, serialized);
		for(int i:serialized)
			System.out.print(i+" ");
		System.out.println();
		Node nn = deserializeArrayToTree(serialized);
		display(nn);
	}  
}
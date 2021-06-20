import java.util.*;

public class VerticalTraversalofBT {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int value){
			data = value;
		}
	}
	static class Pair{
		Node node;
		int horizontalDist;
		Pair(Node nn, int hd){
			node = nn;
			horizontalDist = hd;
		}
	}
	void VerticalTraversalofBT(Node root){
		Queue<Pair> q = new LinkedList<>();
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			Node curr = p.node;
			int hd = p.horizontalDist;
			if(map.containsKey(hd)){
				map.get(hd).add(curr.data);
			}
			else{
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(curr.data);
				map.put(hd, arr);
			}
			if(curr.left!=null) q.add(new Pair(curr.left, hd-1));
			if(curr.right!=null) q.add(new Pair(curr.right, hd+1));
		}
		for(Map.Entry<Integer, ArrayList<Integer>> e: map.entrySet())
			System.out.println(e.getValue());
				
	}
	void TopViewOfABT(Node root){
		Queue<Pair> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			Node curr = p.node;
			int hd = p.horizontalDist;
			if(!map.containsKey(hd)){
				map.put(hd, curr.data);
			}
			if(curr.left!=null) q.add(new Pair(curr.left, hd-1));
			if(curr.right!=null) q.add(new Pair(curr.right, hd+1));
		}
		for(Map.Entry<Integer, Integer> e: map.entrySet())
			System.out.println(e.getValue());
				
	}
	void BottomView(Node root){
		Queue<Pair> q = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()){
			Pair p = q.poll();
			Node curr = p.node;
			int hd = p.horizontalDist;
			map.put(hd, curr.data);
			if(curr.left!=null) q.add(new Pair(curr.left, hd-1));
			if(curr.right!=null) q.add(new Pair(curr.right, hd+1));
		}
		for(Map.Entry<Integer,Integer> e: map.entrySet())
			System.out.println(e.getValue());
				
	}
	public static void main(String[] args){
		VerticalTraversalofBT bst = new VerticalTraversalofBT();
		Node root = new Node(10);  
        root.left = new Node(20);  
        root.right = new Node(30);  
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);
        bst.VerticalTraversalofBT(root);
        System.out.println();
        bst.TopViewOfABT(root);
        System.out.println();
        bst.BottomView(root);

	}
}
import java.io.*;
import java.util.*;

class Node{
	int freq;
	char c;
	Node left, right;
	Node(char c, int freq, Node left, Node right){
		this.freq = freq;
		this.c = c;
		this.left = left;
		this.right = right;
	}	
	int getFreq(){
		return freq;
	}
	char getChar(){
		return c;
	}
}
public class HuffmanCoding {

	public static void main(String[] args) {
		PriorityQueue<Node> heap = new PriorityQueue<Node>(new Comparator<Node>(){
			@Override
			public int compare(Node p1, Node p2){return p1.freq - p2.freq;}
		});

		heap.add(new Node('a', 10, null, null));
		heap.add(new Node('b', 50, null, null));
		heap.add(new Node('d', 20, null, null));
		heap.add(new Node('e', 40, null, null));
		heap.add(new Node('f', 80, null, null));	
		while(heap.size() > 1 ){
			Node left = heap.poll();
			Node right = heap.poll();
			int freq = left.getFreq() + right.getFreq();
			heap.add(new Node('$',  freq , left, right));
		}
		printEncoded(heap.peek(), "");
	}
	public static void printEncoded(Node peek, String str){
		if(peek.getChar() != '$'){
			System.out.println(peek.getChar() + " --> " + str);
			return;
		}
		printEncoded(peek.left, str + "0");
		printEncoded(peek.right, str + "1");
	}
}
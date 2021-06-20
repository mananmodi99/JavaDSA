import java.io.*;
import java.util.*;

public class BFS {
	static void addNode(ArrayList<ArrayList<Integer>> adj, int u, int v){
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	static void printGraph(ArrayList<ArrayList<Integer>> adj){
		for(int u = 0; u<adj.size(); u++){
			System.out.print(u + "--> ");
			for(int v: adj.get(u))
				System.out.print(v + ", ");
		System.out.println();
		}
	}
	public static void main(String[] args) {
		int vertices = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i = 0; i<vertices; i++)
			adj.add(new ArrayList<>());

		addNode(adj, 0, 1);//addNode(adj, u, v)
		addNode(adj, 0, 2);
		addNode(adj, 2, 3);
		addNode(adj, 2, 4);
		printGraph(adj);
		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		boolean visited[] = new boolean[vertices];
		visited[0] = true;
		while(!q.isEmpty()){
			int curr = q.poll();
			System.out.println(curr);
			for(int v : adj.get(curr)){
				if(!visited[v]){
					visited[v] = true;
					q.add(v);
				}
			}
		}
	// }
}
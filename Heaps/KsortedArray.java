import java.util.*;

public class KsortedArray {
	public static void main(String[] args){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		//MinHeap
		int k = 3; 
        int arr[] = { 2, 6, 3, 12, 56, 8 };
		for(int i = 0; i<=k; i++){
			pq.add(arr[i]);
		}
		int index = 0;
		for(int i = k+1; i<arr.length;i++){
			arr[index] = pq.poll();
			index++;
			pq.add(i);
		}
		while(!pq.isEmpty()){
			arr[index] = pq.poll();
			index++;
		}
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	}
}
import java.util.*;

public class KlargestElements {
	public static void main(String[] args){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		//Maxx Heap
		int arr[] = {5,15,10,20,8};
		int k = 2;
		for(int i = 0; i<arr.length; i++){
			//O(nlogn)
			pq.add(arr[i]);
		}
		for(int i = 0; i<k; i++){
			System.out.print(pq.poll() + ", ");
		}
		System.out.println();
		Efficient(arr, k);
	}
	static void Efficient(int arr[], int k){
		//Using Min Heap
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<k; i++){
			pq.add(arr[i]);
		}
		for(int i = k; i<arr.length; i++){
			if(pq.peek()<arr[i]){
				pq.poll();
				pq.add(arr[i]);
			}
		}
		while(!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}
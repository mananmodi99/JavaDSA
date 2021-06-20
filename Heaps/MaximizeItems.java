import java.util.*;

public class MaximizeItems {
	public static void main(String[] args){
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int arr[] = {1,12,5,111,200};
		int sum = 10;
		for(int i = 0; i<arr.length; i++){
			pq.add(arr[i]);
		}
		int count = 0;
		while(sum>pq.peek()){
			sum -= pq.poll();
			count++;
		}
		System.out.println(count);

	}
}
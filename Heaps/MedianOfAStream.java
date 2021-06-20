import java.util.*;

public class MedianOfAStream {
	public static void main(String[] args){
		int arr[] = {25,7,10,15,20};
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		System.out.print(arr[0]+", ");
		maxheap.add(arr[0]);
		for(int i = 1; i<arr.length;i++){
			if(maxheap.size()>minheap.size()){
				if(arr[i]<maxheap.peek()){
					minheap.add(maxheap.poll());
					maxheap.add(arr[i]);
				}
				else{
					minheap.add(arr[i]);
				}
				System.out.print((double)(maxheap.peek()+minheap.peek())/2 + ", ");
			}
			else{
				if(arr[i]<maxheap.peek()){
					maxheap.add(arr[i]);
				}else{
					minheap.add(arr[i]);
					maxheap.add(minheap.poll());
				}
				System.out.print(maxheap.peek()+", ");
			}
		}
	}
}
//package Heaps;
import java.util.*;
import java.io.*;
import java.util.*;

class Pair 
{ 
    Integer key; 
    Integer value; 
      
    public Pair(Integer key, Integer value) 
    { 
        this.key = key; 
        this.value = value; 
    } 
    public Integer getKey() 
    { 
        return key; 
    } 
    public void setKey(Integer key) 
    { 
        this.key = key; 
    } 
    public Integer getValue() 
    { 
        return value; 
    } 
    public void setValue(Integer value) 
    { 
        this.value = value; 
    } 
} 

class KClosestElems{

public static void printKClosest(int arr[], int n, int k, int x)
	{
	    PriorityQueue<Pair> pq = new PriorityQueue<>( 
	                             new Comparator<Pair>() 
	    { 
	        public int compare(Pair p1, Pair p2) 
	        { 
	            return p2.getValue().compareTo( 
	                   p1.getValue()); 
	        } 
	    }); 
	      
	    for(int i = 0; i < k; i++)  
	    { 
	        pq.offer(new Pair(arr[i],  
	                 Math.abs(arr[i] - x))); 
	    } 
	      
	    for(int i = k; i < n; i++) 
	    { 
	        int diff = Math.abs(arr[i] - x); 
	          
	        if(pq.peek().getValue()>diff) {
	        pq.poll(); 
	        pq.offer(new Pair(arr[i], diff)); 
	        }
	    } 
	        
	    while(!pq.isEmpty()) 
	    { 
	        System.out.print(pq.poll().getKey() + " "); 
	    }
	}

	public static void main (String[] args)
	{
		int arr[] = { 10,30,5,40,38,80,70 };

		int size = arr.length;

		int x=35; int k = 3;

		printKClosest(arr,size,k,x);
	}
	static void Naive(int[] arr, int x, int k){
		boolean[] visited = new boolean[arr.length];
		while(k!=0){
			int max_diff = Integer.MAX_VALUE;
			int closest = -1;
			for(int i = 0; i<arr.length;i++){
				if(visited[i]==false && Math.abs(x-arr[i])<max_diff){
					max_diff = Math.abs(x-arr[i]);
					closest = i;
				}
			}
			System.out.println(arr[closest]);
			visited[closest] = true;
			k--; 
		}
	}
}
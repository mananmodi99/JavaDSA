import java.util.*;

public class minHeapImplement {
	int arr[];
	int size, capacity;
	minHeapImplement(int size){
		arr = new int[size];
		this.size = 0; 
		capacity = size;
	}
	int left(int i){ return (2*i+1);}
	int right(int i){ return (2*i+2);}
	int parent(int i){ return Math.abs(i-1)/2;}
	void insert(int val){
		if(size == capacity)
			return;
		size++;
		arr[size-1] = val;
		
		for(int i = size-1; i!=0 && arr[parent(i)]>arr[i];){
			int temp = arr[parent(i)];
			arr[parent(i)] = arr[i];
			arr[i] = temp;
			i = parent(i);
		}
	}
	void display(){
		for(int i = 0; i<arr.length; i++)
			System.out.print(arr[i]+ ", ");
		System.out.println();
	}
	public void Heapify(int i) 
    { 
	    int lt = left(i); 
	    int rt = right(i); 
	    int smallest = i; 
	    if (lt < size && arr[lt] < arr[i]) 
	        smallest = lt; 
	    if (rt < size && arr[rt] < arr[smallest]) 
	        smallest = rt; 
	    if (smallest != i) 
	    { 
	        int temp = arr[i]; 
	        arr[i] = arr[smallest]; 
	        arr[smallest] = temp; 
	        Heapify(smallest); 
    	} 
    }
	
	int extractMin(){
		int min = arr[0];
		if(size == 1){
			size--;
			return min;
		}
       	arr[0] = arr[size-1]; 
       	arr[size-1] = 0;
		size--;
		Heapify(0);
		return min;
	}
	void DecreaseKey(int i, int x){ 
    arr[i] = x; 
	   	while (i != 0 && arr[parent(i)] > arr[i]){ 
	       int temp = arr[i]; 
	       arr[i] = arr[parent(i)]; 
	       arr[parent(i)] = temp; 
	       i = parent(i); 
	    } 
    }
	void Delete(int i){
		DecreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}
	void BuildTree(int arr2[]){
		for(int i = parent(size-1); i>=0; i--){
			Heapify(i);
		}
	}

	public static void main(String[] args){
		minHeapImplement mh = new minHeapImplement(10);
		mh.insert(15);
		mh.insert(10);
		mh.insert(20);
		mh.insert(40);
		mh.insert(45);
		mh.insert(100);
		mh.insert(25);
		mh.insert(50);
		mh.insert(12);
		mh.display();
		mh.Heapify(0);
		mh.display();
		System.out.println(mh.extractMin());
		mh.display();
		mh.DecreaseKey(7, 3);
		mh.display();
		mh.Delete(2);
		mh.display();

	}
}
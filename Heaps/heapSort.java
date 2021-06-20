import java.util.*;

public class heapSort {
	public void buildheap(int arr[],int n){
        for(int i = (arr.length - 2)/2; i>=0; i--)
        	heapify(arr, n, i);
    }
	
	public void sort(int arr[]) 
	{ 
		//building Heap from any tree
		buildheap(arr, arr.length);
		//Selection sort to the array
		int size = arr.length;
		for(int i = 0; i<arr.length; i++){
			int temp = arr[0];
			arr[0] = arr[size-1];
			arr[size-1] = temp;
			size--;
			heapify(arr, size, 0);
		}
	} 

	void heapify(int arr[], int n, int i) 
	{ 
		int left = 2*i+1;
		int right = 2*i+2;
		int largest = i;
		if(left<n && arr[left]>arr[i])
			largest = left;
		if(right<n && arr[right]>arr[largest])
			largest = right;
		if(largest!=i){
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}
	} 

	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i]+" "); 
		System.out.println(); 
	} 
 
	public static void main(String args[]) 
	{ 
		int arr[] = {12, 11, 13, 5, 6, 7, 1}; 
		int n = arr.length; 

		heapSort ob = new heapSort(); 
		ob.sort(arr); 

		System.out.println("Sorted array is"); 
		printArray(arr); 
	} 
}
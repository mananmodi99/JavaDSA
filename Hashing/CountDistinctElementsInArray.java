import java.util.*;

public class CountDistinctElementsInArray {
	public static void main(String[] args){
		int arr[] = {10,20,20,10,30,40,10};
		int arr2[] = {10,10,10,10};
		//Naive(arr, 4, arr.length);
		//Better(arr2, 3, arr2.length);
		Efficient(arr, 4, arr.length);
	}
	static void Efficient(int arr[], int k, int n){
		//O(n) Time
		HashMap<Integer, Integer> map = new HashMap<>();
		//First Window of the Array
		for(int i = 0; i<n-k+1; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(map.size());
		//Ab i-k element ki frequency girao aur k+i element ki badhao
		for(int i = k; i<n; i++){
			map.put(arr[i-k],map.get(arr[i-k])-1);
			if(map.get(arr[i-k]) == 0)
				map.remove(arr[i-k]);
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			System.out.println(map.size());
		}
	}
	static void Better(int arr[], int k, int n){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<(n-k+1); i++){
			int distinct = 0;
			for(int j = i; j<i+k; j++){
				set.add(arr[j]);
			}
			System.out.println(set.size());
			set.clear();
		}
	}
	static void Naive(int arr[], int k, int n){
		for(int i = 0; i<n-k+1; i++){
			int distinct = 0;
			for(int j = 0; j<k; j++){
				boolean flag = false;
				for(int a = 0; a<j; a++){
					if(arr[i+j] == arr[i+a]){
						flag = true;
						break;
					}
				}
				if(flag == false)
					distinct++;
			}
			System.out.println(distinct);
		}
	}
}
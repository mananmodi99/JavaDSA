package Hashing;//package Hashing;
import java.util.*;

public class LengthOfLongestSubarrayWithSum {
	public static void main(String[] args){
		int arr[] = {5,8,-4,-4,9,-2,2};
		int tt2[] = {3,1,0,1,8,2,3,6};
		int tt3[] = {1,2,1,2,1};
		int sum = 5;
		System.out.println(Efficient(tt3, 3));
		System.out.println("\nNaive");
		System.out.println(Naive(tt3, 0));
	}
	static int Naive(int arr[], int sum){
		int max_count = 0;
		for(int i = 0; i<arr.length; i++){
			int curr_sum = arr[i];
			int count = 1;
			for(int j = i+1; j<arr.length; j++){
				curr_sum += arr[j];
				if(curr_sum == sum){
					System.out.println(arr[i] + " <--> " + arr[j]);
					max_count = Math.max(j-i+1,max_count); 
				}
			}
		}
		return max_count;
	}
	static int Efficient(int arr[], int sum){
		HashMap<Integer, Integer> map = new HashMap<>();
		int pref_sum = 0, max_count = 0;
		for(int i = 0; i<arr.length; i++){
			pref_sum += arr[i];
			if(pref_sum == sum)
				max_count = i+1;
			if(map.containsKey(pref_sum - sum))
				max_count = Math.max(max_count, i - map.get(pref_sum - sum)); 
			if(!map.containsKey(pref_sum))
				map.put(pref_sum, i);
		}
		return max_count;
	}
}
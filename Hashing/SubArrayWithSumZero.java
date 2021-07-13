package Hashing;

import java.util.*;

public class SubArrayWithSumZero {
	public static void main(String[] args){
		int arr[] = {0,3,-3,4};
		System.out.println(Naive(arr));
	}
	static boolean Efficient(int arr[]){//Use of prefix Sum and Hashing //O(n)
		HashSet<Integer> set = new HashSet<Integer>();
		int pref_sum = 0;
		for(int i = 0; i<arr.length; i++){
			pref_sum += arr[i];
			if(set.contains(pref_sum))
				return true;
			else if(pref_sum == 0)
				return true;
			else
				set.add(pref_sum);
		}
		return false;
		
	}
	static boolean Naive(int arr[]){//O(n2)
		for(int i = 0; i<arr.length; i++){
			int curr_sum = arr[i];
			for(int j = i+1; j<arr.length; j++){
				curr_sum += arr[j];
				if(curr_sum == 0)
					return true;
			}
		}
		return false;
	}
}
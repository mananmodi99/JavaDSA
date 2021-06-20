import java.util.*;

public class SubArrayWithAnySum {
	public static void main(String[] args){
		int arr[] = {5,8,3,1};
		int sum = 22;
		System.out.println(Naive(arr, sum));
		System.out.println(Efficient(arr, sum));
	}
	static boolean Efficient(int arr[], int sum){
		HashSet<Integer> set = new HashSet<Integer>();
		int pref_sum = 0;
		for(int i = 0; i<arr.length; i++){
			pref_sum += arr[i];
			if(set.contains(pref_sum-sum))
				return true;
			else if(pref_sum == sum)
				return true;
			else
				set.add(pref_sum);
		}
		return false;

	}
	static boolean Naive(int arr[], int sum){//O(n2)
		for(int i = 0; i<arr.length; i++){
			int curr_sum = arr[i];
			for(int j = i+1; j<arr.length; j++){
				curr_sum += arr[j];
				if(curr_sum == sum)
					return true;
			}
		}
		return false;
	}
}
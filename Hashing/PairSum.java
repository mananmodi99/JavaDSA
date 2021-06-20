import java.util.*;

public class PairSum {
	public static void main(String[] args){
		int arr[] = {3,2,8,15,-8};
		int sum = 17;
		System.out.println(Efficient(arr, sum));
		System.out.println(TwoPointer(arr, sum));
	}
	static boolean Efficient(int[] arr, int sum){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i<arr.length;i++){
			if(set.contains(sum-arr[i]))
				return true;
			else
				set.add(arr[i]);
		}
		return false;
	}
	static Boolean TwoPointer(int arr[], int sum){
		Arrays.sort(arr);
		int lo = 0, hi = arr.length-1;
		while(lo<=hi){
			if(arr[lo]+arr[hi] == sum)
				return true;
			else if(arr[lo] + arr[hi] < sum)
				lo++;
			else hi--;
		}
		return false;
	}
}
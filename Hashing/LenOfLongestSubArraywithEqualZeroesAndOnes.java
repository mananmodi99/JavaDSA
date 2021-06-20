import java.util.*;

public class LenOfLongestSubArraywithEqualZeroesAndOnes {
	public static void main(String[] args){
		int arr[] = {1,0,1,1,1,0,0};
		System.out.println(Naive(arr));

		System.out.println(Efficient(arr));
	}
	static int Efficient(int arr[]){
		//Replace all 0s with -1s - Amazing na?
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == 0) arr[i] = -1;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		int pref_sum = 0, max_count = 0;
		for(int i = 0; i<arr.length; i++){
			pref_sum += arr[i];
			if(map.containsKey(pref_sum))
				max_count = Math.max(max_count, i - map.get(pref_sum));
			if(pref_sum == 0)
				max_count = Math.max(max_count, i + 1);
			if(!map.containsKey(pref_sum))
				map.put(pref_sum, i);
		}
		return max_count;
	}
	static int Naive(int arr[]){//Theta(n2)
		int len = 0;
		for(int i = 0; i<arr.length; i++){
			int zero = 0, one = 0;
			for(int j = i; j<arr.length; j++){
				if(arr[j] == 0)
					zero++;
				else
					one++;
				if(one == zero)
					len = Math.max(len, zero+one);
			}
		}
		return len;
	}
}
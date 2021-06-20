import java.util.*;

public class LongestCommonSubArrayin2Arrays {
	public static void main(String[] args){
		int a[] = {0,1,0,0,0,0};
		int b[] = {1,0,1,0,0,1};
		System.out.println(Naive(a,b));
		System.out.println(Efficient(a,b));
	}
	static int Efficient(int a[], int b[]){
		//Difference Array//assumed they have same length
		int diff[] = new int[a.length];
		for(int i = 0; i<a.length; i++){
			diff[i] = a[i] - b[i];
		}
		//Now apply longest common subarray with zero sum 0, on diff array
		HashMap<Integer, Integer> map = new HashMap<>();
		int pref_sum = 0, max_count = 0;
		for(int i = 0; i<diff.length; i++){
			pref_sum += diff[i];
			if(map.containsKey(pref_sum))
				max_count = Math.max(max_count, i - map.get(pref_sum));
			if(pref_sum == 0)
				max_count = Math.max(max_count, i + 1);
			if(!map.containsKey(pref_sum))
				map.put(pref_sum, i);
		}
		return max_count;

	}
	static int Naive(int a[], int b[]){
		int max_count = 0;
		for(int i = 0; i<a.length; i++){
			int sum_a = 0;
			int sum_b = 0;
			for(int j = i; j<a.length; j++){
				sum_a += a[j];
				sum_b += b[j];
				if(sum_a == sum_b)
					max_count = Math.max(j-i+1,max_count);
			}
		}
		return max_count;
	}
}
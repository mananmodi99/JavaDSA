import java.util.*;

public class CountDistinctElements {
	public static void main(String[] args){
		HashSet<Integer> hash = new HashSet<Integer>();
		int arr[] = {15,12,13,12,13,13,18};
		for(int i = 0; i<arr.length; i++){
			hash.add(arr[i]);
		}
		System.out.println(hash.size());
	}
	
}
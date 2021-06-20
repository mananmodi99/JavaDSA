import java.util.*;

public class UnionOf2Arrays {
	public static void main(String[] args){
		HashSet<Integer> set = new HashSet<Integer>();
		int[] arr1 = {15,20, 5, 15, 20, 10};
		int[] arr2 = {15, 5, 15, 20, 10};
		for(int i= 0; i<arr1.length; i++)
			set.add(arr1[i]);		
		for(int i= 0; i<arr2.length; i++)
			set.add(arr2[i]);
		System.out.println(set.size());
	}
}
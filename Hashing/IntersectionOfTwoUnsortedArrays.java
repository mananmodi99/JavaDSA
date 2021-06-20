import java.util.*;

public class IntersectionOfTwoUnsortedArrays {
	public static void main(String[] args){
		int arr1[] = {10,15,20,5,30};
		int arr2[] = {30,5,30,80};
		System.out.println(NaiveApproach(arr1, arr2));
		System.out.println(Efficient2(arr1, arr2));
			
	}
	static int Efficient2(int arr1[], int arr2[]){
		HashSet<Integer> set1 = new HashSet<Integer>();
		for(int i = 0; i<arr1.length; i++){
			set1.add(arr1[i]);
		}
		int common = 0;
		for(int i = 0;i<arr2.length; i++){
			if(set1.contains(arr2[i])){
				common++;
				set1.remove(arr2[i]);
			}
		}
		return common;
	}
	static int Efficient1(int arr1[], int arr2[]){
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		for(int i = 0; i<arr1.length; i++){
			set1.add(arr1[i]);
		}
		for(int i = 0; i<arr2.length; i++){
			set2.add(arr2[i]);
		}
		int common = 0;
		Iterator<Integer> i = set2.iterator();
		while(i.hasNext()){
			if(set1.contains(i)){
				common++;
			}
		}
		return common;
	}
	static int NaiveApproach(int arr1[], int arr2[]){
		int common = 0;
		for(int i = 0; i<arr1.length;i++){
			boolean flag = false;
			for(int j = 0; j<i; j++){
				if(arr1[i] == arr1[j]){// to run the loop only for distinct elems only
					flag = true;
					break;
				}
			}
			if(flag == true)
				continue;
			for(int j = 0; j<arr2.length; j++){
				if(arr1[i] == arr2[j]){
					common++;
					break; // agar 2nd array mein bhi items are present 2 times so to avoid that we have to break;
				}
			}
		}
		return common;
	}
}
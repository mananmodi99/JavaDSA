import java.util.*;

public class LongestCommonSubsequence {
	public static void main(String[] args){
		int tt1[] = {1,9,3,4,2,20};
		int tt2[] = {8,8,20,7,7,9,30, 23, 21, 22, 24};
		int tt3[] = {20,30,40};
		System.out.println(Naive(tt1));
		System.out.println(Efficient(tt1));
	}
	static int Efficient(int arr[]){
		HashSet<Integer> set = new HashSet<>();
		for(int i = 0;i<arr.length; i++){
			set.add(arr[i]);
		}
		int len = 1, curr = 1;
		for(int i = 0;i<arr.length; i++){
			if(!set.contains(arr[i]-1)){
				int elem = arr[i];
				while(set.contains(elem+1)){
					curr++;
					elem++;
				}
			}
			else if(set.contains(arr[i]-1)){
				len = Math.max(curr, len);
				curr = 1;
			}
		}
		return len;
	}
	static int Naive(int arr[]){
		Arrays.sort(arr);
		System.out.print("Array is: ");
		for(int i: arr){
			System.out.print(i+", ");
		}
		System.out.println();
		int len = 1, curr = 1;
		for(int i = 1;i<arr.length; i++){
			if(arr[i] == arr[i-1] + 1) curr++;
			else if(arr[i]!=arr[i-1]){ //similar elems ko bhagao
			 len = Math.max(len, curr); 
			 curr=1;//to start the counting of a new subsequence if it exist
			}
		}
		System.out.println();
		return len;
	}
}
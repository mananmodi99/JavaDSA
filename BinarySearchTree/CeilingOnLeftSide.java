import java.util.*;

public class CeilingOnLeftSide {
	public static void main(String[] args){
		TreeSet<Integer> t = new TreeSet<Integer>();
		int[] arr = {2,8,30,15,25,12};
		t.add(arr[0]);
		System.out.print(-1+" ");
		for(int i = 1; i<arr.length; i++){
			try{
				int ceil = t.ceiling(arr[i]);
				System.out.print(ceil + " ");
			}
			catch (Exception e){
				System.out.print(-1 + " ");
			}
			t.add(arr[i]);
		}
	}
}
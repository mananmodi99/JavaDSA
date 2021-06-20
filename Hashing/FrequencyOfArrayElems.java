import java.util.*;

public class FrequencyOfArrayElems {
	public static void main(String[] args){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int arr[] = {10,12,10,15,10,20,12,12};
		for(int i=0; i<arr.length; i++){ 
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);	
		}
		System.out.println(map);
		for(Map.Entry<Integer, Integer> e : map.entrySet())
			System.out.println(e.getKey() + " " + e.getValue());
		System.out.println();
		System.out.println();
		NaiveApproach(arr);
	}
	static void NaiveApproach(int arr[]){
		for(int i = 0; i<arr.length; i++){
			int freq = 1;
			boolean flag = false;
			for(int j = 0; j<i; j++){
				if(arr[i] == arr[j]){
					flag = true;
					break;
				}
			}
			if(flag == true) continue;
			for(int j = i+1; j<arr.length; j++){
				if(arr[i] == arr[j])
					freq++;
			}
			System.out.println(arr[i] + " " + freq);
		}
		
	}
}
import java.util.*;

public class MoreThanNByKOccurences {
	public static void main(String[] args){
		int arr[] = {30, 10, 20, 20, 20, 10, 40, 30, 30};
		int k = 4;
		System.out.println(arr.length/k);
		Naive(arr, arr.length/k);
		Efficientv2(arr, 4);
	}
	static void Efficient(int arr[], int factor){//Time : Theta(n) Aux Space: O(n)
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<arr.length; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		System.out.println(map);
		for(Map.Entry<Integer, Integer> e: map.entrySet()){
			if(e.getValue()>factor)
				System.out.println(e.getKey());
		}
	}
	static void Naive(int[] arr, int factor){//Overall Time:Theta(nlogn)
		Arrays.sort(arr);//Theta(nlogn)
		int i = 1, count = 1, n = arr.length; 
		while(i<n){//O(n)
			while(i<n && arr[i] == arr[i-1]){
				count++;
				i++;
			}
			if(count>factor)
				System.out.println(arr[i-1]);
			count = 1;
			i++;
		}
	}
	static void Efficientv2(int[] arr, int k){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
                int count=map.get(arr[i]);
                map.put(arr[i],count+1);
            }
			else if(map.size()<k-1){
				map.put(arr[i], 1);
			}
			else{
				for(Map.Entry e:map.entrySet()){
                    Integer val = (Integer) e.getValue();
                    map.put((Integer) e.getKey(), val-1);
                    if((Integer) e.getKey() == 0)
                        map.remove(e.getKey());
                }
			}
		}
		for(Map.Entry e:map.entrySet()){
			int count = 0;
			for(int i = 0; i<arr.length; i++){
				if(arr[i] == (Integer) e.getKey())
					count++;
			}
			if(count>arr.length/k){
				System.out.println(e.getKey());
			}
		}
		System.out.println(map);
	}
}
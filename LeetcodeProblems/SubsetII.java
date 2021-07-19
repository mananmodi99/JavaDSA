package LeetcodeProblems;
import java.util.*;
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        PowerSet(arr, 0, subset, ans);
        return subset;
    }
    public void PowerSet(int[] arr, int ptr, List<List<Integer>> subset, List<Integer> list){
        //base
        subset.add(new ArrayList<>(list));
        for(int i= ptr; i<arr.length; i++){
            if(i>ptr && arr[i-1] == arr[i]) continue;
            list.add(arr[i]);
            PowerSet(arr, i+1, subset, list);
            list.remove(list.size()-1);
        }
    }
}

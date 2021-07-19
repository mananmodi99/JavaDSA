package LeetcodeProblems;
import java.util.*;
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> sets = new ArrayList<>();
        Arrays.sort(arr);
        combSum(arr, target, sets, new ArrayList<Integer>(),0);
        return sets;
    }
    public static void combSum(int[] arr, int target,List<List<Integer>> sets, List<Integer> list, int idx)
    {
        if(target<0){
            return;
        }
        else if(target == 0){
            if(!sets.contains(list))
                sets.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            list.add(arr[i]);
            combSum(arr, target-arr[i], sets, list, i+1);
            list.remove(list.size()-1);
        }
    }
}

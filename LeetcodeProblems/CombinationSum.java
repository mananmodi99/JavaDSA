package LeetcodeProblems;
import java.util.*;
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] arr, int target) {
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
            sets.add(new ArrayList<>(list));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            list.add(arr[i]);
            combSum(arr, target-arr[i], sets, list, i);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }
}

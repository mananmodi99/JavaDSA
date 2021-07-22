package LeetcodeProblems;
import java.util.*;
public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list = permute(new int[]{1,2,3});
        System.out.println(list);

    }
    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i<nums.length; i++) arr.add(nums[i]);
        List<Integer> ans = new ArrayList<Integer>();
        List<List<Integer>> mainList = new ArrayList<>();
        permutations(nums, ans, mainList);
        return mainList;
    }
    public static void permutations(int[] arr, List<Integer> ans, List<List<Integer>> mainList){
        //base
        if(ans.size() == arr.length){
            mainList.add(new ArrayList<>(ans));
            return;
        }
        //recursive
        for(int i = 0; i<arr.length; i++){
            if(ans.contains(arr[i])) continue;
            ans.add(arr[i]);
            permutations(arr, ans, mainList);
            ans.remove(ans.size()-1);
        }
    }
}

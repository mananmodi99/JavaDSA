package LeetcodeProblems;

import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> subset = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        PowerSet(arr, 0, subset, ans);
        return subset;
    }
    public static void PowerSet(int[] arr, int ptr, List<List<Integer>> subset, List<Integer> list){
        //base
        if(ptr>=arr.length){
            subset.add(new ArrayList<Integer>(list));
            return;
        }
        //recursive
        list.add(arr[ptr]);
        PowerSet(arr, ptr+1, subset, list);
        list.remove(list.size()-1);
        PowerSet(arr, ptr+1, subset, list);
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = subsets(new int[]{1,2,3});
        System.out.println(ans);
    }
}

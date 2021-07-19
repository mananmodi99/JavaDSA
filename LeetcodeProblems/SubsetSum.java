package LeetcodeProblems;

import java.util.*;

public class SubsetSum {
    static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        SubsetSum(arr, 0, N, 0, ans);
        return ans;
    }
    static void SubsetSum(ArrayList<Integer> arr, int ptr, int n, int sum, ArrayList<Integer> ans){
        //base
        if(ptr>=n){
            ans.add(sum);
            return;
        }
        //recursive
        SubsetSum(arr, ptr+1, n, sum+arr.get(ptr), ans);
        SubsetSum(arr, ptr+1, n, sum, ans);
    }

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<Integer>();
        ans = subsetSums(new ArrayList<Integer>(Arrays.asList(5, 2, 1)), 3);
        Collections.sort(ans);
        System.out.println(ans);
    }
}

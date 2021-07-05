package LeetcodeProblems;
//Problem Link(268 Leetcode): https://leetcode.com/problems/missing-number/
import java.util.*;
public class MissingNumbers {
    public int missingNumberNaive(int[] arr) {
        //TC: O(nlogn) SC: O(1)
        Arrays.sort(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] != i) return i;
        }
        return arr.length;
    }
    public int missingNumberBest(int[] arr) {
        //TC: O(n) SC: O(1)
        int sum = (arr.length)*(arr.length+1)/2; //(n(n+1)/2)
        for(int i = 0; i<arr.length; i++){
            sum -= arr[i];
        }
        return sum;
    }
}

package LeetcodeProblems;

import java.util.HashMap;

public class TwoSum {
    //Problem Link:https://leetcode.com/problems/two-sum/
    public int[] twoSum(int[] arr, int target) {
        int[] temp = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=  0; i<arr.length; i++){
            if(map.containsKey(target-arr[i])){
                temp[0] = i;
                temp[1] = map.get(target-arr[i]);
                return temp;//so that it does not consider itself only like target: 6 , diff = 6-3, elem 3, temp[1,1]
            }
            map.put(arr[i], i);
        }
        return temp;
    }
    public int[] Naive(int[] nums, int target) {
        int arr[] = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}

package LeetcodeProblems;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        List<List<Integer>> list = fourSum(new int[]{0,0,4,-2,-3,-2,-2,-3},-1);
        System.out.println(list);
    }
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> quad = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
            if(i>0 && arr[i-1] == arr[i]){continue;}
            for(int j = i+1; j<arr.length;j++){
                if(j>i+1 && arr[j-1] == arr[j]){continue;}
                int lo = j+1, hi = arr.length-1, rem = target-arr[i]-arr[j];
                while(lo<hi){
                    quad = new ArrayList<>();
                    if(arr[lo]+arr[hi] == rem){
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[lo]);
                        quad.add(arr[hi]);
                        list.add(quad);
                        while(lo<hi && arr[lo] == quad.get(2)){++lo;}
                        while(lo<hi && arr[hi-1] == quad.get(3)){--hi;}
                    }
                    else if(arr[lo]+arr[hi]<rem){
                        lo++;
                    }
                    else if(arr[lo]+arr[hi] > rem){
                        hi--;
                    }
                }
            }
        }
        return list;
    }
}

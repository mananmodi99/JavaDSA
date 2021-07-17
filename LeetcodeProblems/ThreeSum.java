package LeetcodeProblems;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i<arr.length-1; i++){
            if(i>0 && arr[i] == arr[i-1]) continue;
            int lo = i+1, hi = arr.length-1;
            while(lo<hi){
                if(arr[lo]+arr[hi] == -1*arr[i]){
                    List<Integer> found = new ArrayList<>();
                    found.add(arr[i]);
                    found.add(arr[lo]);
                    found.add(arr[hi]);
                    list.add(found);
                    while(lo<hi && arr[lo] == found.get(1)){lo++;}
                    while(lo<hi && arr[hi] == found.get(2)){hi--;}
                }
                else if(arr[lo]+arr[hi]>-1*arr[i]){
                    hi--;
                }
                else if(arr[lo]+arr[hi]<-1*arr[i]){
                    lo++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }
}

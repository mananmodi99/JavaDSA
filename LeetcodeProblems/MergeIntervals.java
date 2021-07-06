package LeetcodeProblems;
import java.util.*;
//Problem Link: https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {

    public int[][] merge(int[][] arr) {
        if(arr.length == 0 || arr == null || arr.length == 1) return arr;

        Arrays.sort(arr, new Comparator<int []>(){
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        });

        List<int[]> list = new ArrayList();
        int start = arr[0][0];
        int end = arr[0][1];
        for(int[] i : arr){
            if(i[0]<=end)
                end = Math.max(end, i[1]);
            else{
                list.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[0][]);
    }
}

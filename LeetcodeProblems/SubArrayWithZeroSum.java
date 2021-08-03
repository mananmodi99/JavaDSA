package LeetcodeProblems;

import java.util.*;

public class SubArrayWithZeroSum {
    public static void main(String[] args) {
        System.out.println(NumberOfsubarraysWithGivenSum(new int[]{15,-2,2,-8,1,7,10,23},15));
    }
    static int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;
        for(int i = 0; i<arr.length; i++){
            if(!map.containsKey(sum+arr[i])){
                map.put(sum+arr[i], i);
                sum+=arr[i];
            }
            else{
                len = Math.max(i-map.get(sum+arr[i]), len);
                sum+=arr[i];
            }
        }
        return len;
    }
    static int Naive(int arr[]){//O(n2)
        int len =0;
        for(int i = 0; i<arr.length; i++){
            int curr_sum = arr[i];
            for(int j = i+1; j<arr.length; j++){
                curr_sum += arr[j];
                if(curr_sum == 0)
                    len = Math.max(j-i+1, len);
            }
        }
        return len;
    }
    public static int NumberOfsubarraysWithGivenSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count=0,sum=0;
        map.put(0,1);

        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(map.containsKey(sum-k))
            {
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}

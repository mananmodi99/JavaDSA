package LeetcodeProblems;
import java.util.*;
public class MaxProfInJobScheduling {
    static class Time implements Comparable<Time>{
        int start, end, profit;
        Time(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public int compareTo(Time t){
            return this.end - t.end;
        }
    }
    public static int jobScheduling(int[] start, int[] end, int[] profit) {
        int n = start.length;
        Time[] time = new Time[n];
        int endMax = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            time[i] = new Time(start[i], end[i], profit[i]);
            endMax = Math.max(endMax, end[i]);
        }
        Arrays.sort(time);
        int[][] dp = new int[n+1][endMax+1];
        for(int arr[]:dp){
            Arrays.fill(arr, -1);
        }
        return MaxProfTopDown(time, n);
    }
    public static int MaxProfTopDown(Time[] time, int n){
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;
        dp[0] = time[0].profit;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(time[i].profit, dp[i-1]);
            for (int j = i-1; j >= 0; j--){
                if(time[i].start >= time[j].end){
                    dp[i] = Math.max(dp[i], time[i].profit + dp[j]);
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int MaxProf(Time[] time, int[] profit, int end, int i, int n, int[][] dp){
        //Stack Overflow on Leetcode - Bottom Up
        //Sort based on start time
        if(i == n) return 0;
        if(dp[i][end] == -1){
            if(time[i].start>=end)
                dp[i][end] = Math.max(time[i].profit + MaxProf(time, profit, time[i].end, i+1, n, dp), MaxProf(time, profit, end, i+1, n, dp));
            else
                dp[i][end] = MaxProf(time, profit, end, i+1, n, dp);
        }
        return dp[i][end];
    }

    public static void main(String[] args) {
        System.out.println(jobScheduling(new int[]{4,2,4,8,2}, new int[]{5,5,5,10,8}, new int[]{1,2,8,10,4}));
    }
}

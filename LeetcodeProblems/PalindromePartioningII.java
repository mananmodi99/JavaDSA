package LeetcodeProblems;
import java.util.*;
public class PalindromePartioningII {
    public int minCut(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return (int) PalindromePartioning(s, 0, s.length()-1, dp);
        //MCM
    }
    public int PalindromePartioning(String s, int i, int j, int[][] dp){
        if(i>=j) return 0;
        if(isPalindrome(s, i, j)){
            return 0;
        }
        if(dp[i][j] == -1){
            int min = Integer.MAX_VALUE;
            for(int k = i; k<j; k++){
                int temp = 1;
                if(dp[i][k]!=-1){
                    temp+=dp[i][k];
                }
                else{
                    temp+=PalindromePartioning(s, i, k, dp);
                }

                if(dp[k+1][j]!=-1){
                    temp+=dp[k+1][j];
                }
                else{
                    temp+=PalindromePartioning(s, k+1, j, dp);
                }
                min = Math.min(min, (int) temp);
            }
            dp[i][j] = min;
        }
        return dp[i][j];
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) == s.charAt(end)){
                start++;end--;
            }
            else
                return false;
        }
        return true;
    }
}

package LeetcodeProblems;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        String b = "";
        for(int i = s.length()-1; i>=0; i--)
            b += s.charAt(i);
        int n = s.length();
        return palin(s, b, n);
    }
    static int palin(String s1, String s2, int n){
        // code here
        int[][] dp = new int[n+1][n+1];
        int max = Integer.MIN_VALUE;
        int row = 0, col= 0;
        for(int i = 1; i<n+1; i++){
            for(int j =1; j<n+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[n][n];
    }
    //Min no. of deletions to make a string palindrome
    static int len(String s1,int n){
        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        int len_lps = palin(s1, sb.toString(), s1.length());
        return s1.length() - len_lps;
    }
}

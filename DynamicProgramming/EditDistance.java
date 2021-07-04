package DynamicProgramming;

import java.util.*;
public class EditDistance {
    public static void main(String[] args) {
        String s1 = "CAT";
        String s2 = "CUT";
        System.out.println(convertStrOnetoTwo_Rec(s1, s2, s1.length()-1, s2.length()-1));
        int memo[][] = new int[s1.length()][s2.length()];
        for(int[] i : memo){
            Arrays.fill(i, -1);
        }
        System.out.println(convertStrOnetoTwo_dp(s1, s2, s1.length()-1, s2.length()-1, memo));
        System.out.println(convertStrOnetoTwo_dp_tab(s1, s2, s1.length(), s2.length()));


    }
    static int convertStrOnetoTwo_Rec(String s1, String s2, int m, int n){
        //Base case
        if(m == 0)
            return n;
        if(n == 0)
            return m;
        //Recursion
            //Same
        if(s1.charAt(m) == s2.charAt(n)){
            return convertStrOnetoTwo_Rec(s1, s2, m-1, n-1);
        }
        else{
            //minOfInsertorDeleteorReplace
            return 1+Math.min(Math.min(convertStrOnetoTwo_Rec(s1, s2, m, n-1), convertStrOnetoTwo_Rec(s1, s2, m-1, n)), convertStrOnetoTwo_Rec(s1, s2, m-1, n-1));
        }
    }

    static int convertStrOnetoTwo_dp(String s1, String s2, int m, int n, int[][] memo){
        //Base case
        if(memo[m][n] == -1) {
            if (m == 0)
                memo[m][n] = n;
            if (n == 0)
                memo[m][n] = m;
            //Recursion
            //Same
            if (s1.charAt(m) == s2.charAt(n)) {
                memo[m][n] = convertStrOnetoTwo_Rec(s1, s2, m - 1, n - 1);
            } else {
                //minOfInsertorDeleteorReplace
                memo[m][n] = 1 + Math.min(Math.min(convertStrOnetoTwo_Rec(s1, s2, m, n - 1), convertStrOnetoTwo_Rec(s1, s2, m - 1, n)), convertStrOnetoTwo_Rec(s1, s2, m - 1, n - 1));
            }
        }
        return memo[m][n];
    }
    static int convertStrOnetoTwo_dp_tab(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < n+1; j++) {
            dp[0][j] = j;
        }
        for(int i = 1; i<m+1 ; i++){
            for (int j = 1; j < n+1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    //Insert or Delete or Replace
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]);
            }
        }
        return dp[m][n];
    }
}

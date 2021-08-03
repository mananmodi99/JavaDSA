package DynamicProgramming;

import java.util.*;

public class BooleanParenthization {
    public static void main(String[] args) {
        //System.out.println(BoolParenthization("T|F&T^F", 0, 6, true, new HashMap<String, Integer>());
    }
    static int countWays(int N, String S){
        int[][][] dp = new int[N+1][N+1][2];
        for(int arr[][]:dp){
            for(int inAr[]:arr){
                Arrays.fill(inAr, -1);
            }
        }
        return BoolParenthization(S, 0, N-1, true, dp);
    }
    public static int BoolParenthization(String str, int i, int j, boolean isTrue, int[][][] dp){
        if(i>j) return 0;
        if(i == j){
            if(isTrue)
                return (str.charAt(i) == 'T')?1:0;
            else
                return (str.charAt(i) == 'F')?1:0;
        }
        String temp = i+" "+j+" "+isTrue;
        int ans = 0, x = 0;
        if(isTrue) x = 0;
        else x = 1;
        if(dp[i][j][x] == -1){
            for(int k = i+1; k<j; k+=2){
                int lt = BoolParenthization(str, i, k, true, dp);
                int rt = BoolParenthization(str, k+1, j, true, dp);
                int lf = BoolParenthization(str, i, k, false, dp);
                int rf = BoolParenthization(str, k+1, j, true, dp);
                if(str.charAt(i) == '&') {
                    if (isTrue)
                        ans += (lt * rt);
                    else
                        ans += (lt * rf) + (rt * lf) + (lf * rf);
                }
                else if(str.charAt(i) == '|') {
                    if (isTrue)
                        ans += (lt * rt) + (lt * rf) + (rt * lf);
                    else
                        ans += (lf * rf);
                }
                else{
                    if (isTrue)
                        ans += (lt * rf) + (rt * lf);
                    else
                        ans += (lf * rf)+(rt * lt);
                }
            }
            dp[i][j][x] = ans;
        }
        return dp[i][j][x];
    }
}

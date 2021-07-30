package LeetcodeProblems;

public class PrintLCS {
    public static String lcs_print(String s1, String s2, int n, int m){
        String[][] dp = new String[n+1][m+1];
        for(int i = 0; i<n+1; i++)
            for(int j = 0; j<m+1; j++)
                if(i==0||j==0)
                    dp[i][j] = "";

        for (int i = 1; i < n+1; i++) {
            for(int j = 1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                else
                    dp[i][j] = (dp[i-1][j].length()>=dp[i][j-1].length())?dp[i-1][j]:dp[i][j-1];
            }

        }
        return dp[n][m];
    }

}

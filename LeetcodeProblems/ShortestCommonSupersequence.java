package LeetcodeProblems;

public class ShortestCommonSupersequence {
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        return m+n-LCS(X, Y, m, n);
    }
    public static int LCS(String s1, String s2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i<n+1; i++){
            for(int j = 0; j<m+1; j++)
                if(i == 0 || j==0)
                    dp[i][j] = 0;
        }

        for(int i = 1; i<n+1; i++){
            for(int j = 1; j<m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int i = n, j = m;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;j--;
            }
            else{
                if(dp[i][j-1]>dp[i-1][j]){
                    sb.append(str2.charAt(j-1));
                    j--;
                }
                else{
                    sb.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
}

package LeetcodeProblems;

public class LongestCommonSubstring {
    static String longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int[][] dp = new int[n+1][m+1];
        int max = Integer.MIN_VALUE;
        int row = 0, col= 0;
        for(int i = 1; i<n+1; i++){
            for(int j =1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(max<dp[i][j]){
                        max = dp[i][j];
                        row = i;
                        col = j;

                    }
                }
                else
                    dp[i][j] = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(max>0){
            sb.append(s1.charAt(row-1));
            row--;
            col--;
            max--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("aacabdkacaa", "aacakdbacaa", 11, 11));
    }
}

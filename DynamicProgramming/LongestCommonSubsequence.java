package DynamicProgramming;
import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "axyz", str2 = "baz";
		int[][] memo = new int[str1.length()+1][str2.length()+1];
		for(int[] i : memo){
			Arrays.fill(i, -1);
		}
		System.out.println(lcs_memo(str1,str2, str1.length()-1, str2.length()-1, memo)+1);
		System.out.println(lcs_tab(str1, str2));
	}
	//Recursive
	static int LCS_rec(String str1, String str2, int m, int n){
		if(m == 0 || n == 0) return 0;
		if(str1.charAt(m) == str2.charAt(n)) return 1+LCS_rec(str1, str2, m-1, n-1);
		else {
			return Math.max(LCS_rec(str1, str2, m - 1, n), LCS_rec(str1, str2, m, n - 1));

		}
	}
	static int lcs_memo(String str1, String str2, int m, int n, int[][] memo){
		if(memo[m][n] == -1) {
			if (m == 0 || n == 0) memo[m][n] = 0;
			else {
				if(str1.charAt(m) == str2.charAt(n))
					memo[m][n] = 1 + lcs_memo(str1, str2, m-1, n-1, memo);
				else
					memo[m][n] = Math.max(lcs_memo(str1, str2, m - 1, n, memo), lcs_memo(str1, str2, m, n - 1, memo));
			}
		}
		return memo[m][n];
	}
	static int lcs_tab(String str1, String str2){
		int m = str1.length(), n = str2.length();
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i<=m; i++)
			dp[i][0] = 0;
		for(int j = 0; j<=n; j++)
			dp[0][j] = 0;

		for(int i = 1; i<=m; i++){
			for(int j = 1; j<=n; j++){
				if(str1.charAt(i-1) == str2.charAt(j-1))
					dp[i][j] = 1 + dp[i-1][j-1];
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		return dp[m][n];
	}

}
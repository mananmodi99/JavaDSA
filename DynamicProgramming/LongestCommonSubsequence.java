import java.io.*;
import java.util.*;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String str1 = "axyz", str2 = "baz";
		System.out.println(LCS_rec(str1,str2, str1.length()-1, str2.length()-1)+1);
	}
	//Recursive
	static int LCS_rec(String str1, String str2, int m, int n){
		if(m == 0 || n == 0) return 0;
		if(str1.charAt(m) == str2.charAt(n)) return 1+LCS_rec(str1, str2, m-1, n-1);
		else{
			return Math.max(LCS_rec(str1, str2, m-1, n), LCS_rec(str1, str2, m, n-1));
		}
	}
}
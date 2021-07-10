package LeetcodeProblems;
import java.util.*;
//Problem Link:
public class UniquePaths {
    public static int BruteForce(int m, int n) {
        if(m == 1 && n == 1) return 1;
        if(m<1 || n<1) return 0;
        //recursion
        int count = 0;
        count += BruteForce(m-1, n);
        count += BruteForce(m, n-1);
        return count;
    }
    public int Best(int m, int n) {
        int[][] memo = new int[m][n];
        for(int[] a:memo)
            Arrays.fill(a, -1);
        return paths(memo, m-1, n-1);
    }

    public int paths(int[][] memo, int m, int n){
        //DP: Memorization
        if(m == 0 && n == 0) return 1;
        if(m<0 || n<0) return 0;

        if(memo[m][n] == -1){
            //recursion
            memo[m][n] = paths(memo, m-1, n) + paths(memo, m, n-1);//right;//down
        }
        return memo[m][n];
    }
}

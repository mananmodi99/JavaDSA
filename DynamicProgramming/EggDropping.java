package DynamicProgramming;
import java.util.*;
public class EggDropping {
    public int superEggDrop(int k, int n) {
        int[][] dp = new int[k+1][n+1];
        for(int[] arr:dp){
            Arrays.fill(arr, -1);
        }
        return eggDrop(k, n, dp);
    }
    public int eggDrop(int k, int n, int[][] dp){
        if(k == 1) return n;
        if(n==0 || n == 1) return n;
        if(dp[k][n] == -1){
            int ans = Integer.MAX_VALUE;
            int lo = 1, hi = n;
            while(lo<=hi){
                int f = (lo+hi)/2;
                int up = 0;
                int down = 0;
                if(dp[k-1][f-1] == -1)
                    down = eggDrop(k-1, f-1, dp);
                else
                    down = dp[k-1][f-1];

                if(dp[k][n-f] == -1)
                    up = eggDrop(k, n-f, dp);
                else
                    up = dp[k][n-f];

                int temp = 1 + Math.max(up, down);
                ans = Math.min(ans, temp);
                if(up>down) lo = f+1;
                else hi = f-1;
            }
            dp[k][n] = ans;
        }
        return dp[k][n];
    }
}

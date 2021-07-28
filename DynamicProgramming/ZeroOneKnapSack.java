package DynamicProgramming;
import java.util.*;
public class ZeroOneKnapSack {
    //Recursive
    static int knapSack(int W, int wt[], int val[], int n)
    {
        if(n == 0 || W == 0)
            return 0;
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapSack(W-wt[n-1], wt, val, n-1), knapSack(W, wt, val, n-1));
        }
        else{
            return knapSack(W, wt, val, n-1);
        }
    }

    //Memo
    static int knapSack_m(int W, int wt[], int val[], int n)
    {
        int[][] t = new int[n+1][W+1];
        for(int i = 0; i<n+1; i++) Arrays.fill(t[i], -1);
        return KnapSack_memo(W,wt, val, n, t);

    }
    static int KnapSack_memo(int W, int[] wt, int val[], int n, int[][] t ){
        if(n == 0 || W == 0)
            return 0;
        if(t[n][W] == -1){
            if(wt[n-1] <= W){
                t[n][W] = Math.max(val[n-1] + KnapSack_memo(W-wt[n-1], wt, val, n-1, t), KnapSack_memo(W, wt, val, n-1, t));
            }
            else{
                t[n][W] = KnapSack_memo(W, wt, val, n-1, t);
            }
        }
        return t[n][W];
    }

    //Tabulation
    static int knapSack_tab(int W, int wt[], int val[], int n)
        {
            int[][] t = new int[n+1][W+1];
            for(int i = 0; i<n+1; i++){
                for(int j = 0; j<W+1; j++){
                    if(i==0 || j==0)
                        t[i][j] = 0;
                }
            }


            for(int i = 1; i<n+1; i++){
                for(int j = 1; j<W+1; j++){
                    if(wt[i-1]<=j){
                        t[i][j] = Math.max(val[i-1]+t[i-1][j-wt[i-1]], t[i-1][j]);
                    }
                    else{
                        t[i][j] = t[i-1][j];
                    }
                }
            }
            return t[n][W];
        }
    public static void main(String[] args) {
        System.out.println(knapSack_tab(4, new int[]{4,5,1}, new int[]{1,2,3}, 3));
    }
}

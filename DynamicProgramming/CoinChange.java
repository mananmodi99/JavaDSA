package DynamicProgramming;

public class CoinChange {
    static int soln= 0;
    public static void main(String[] args) {
        int[] coins = {2,3, 5, 6};
        int sum = 10;
        Denominations_rec(coins, sum, 0, "");
        System.out.println(soln);
        System.out.println();
        System.out.println(Denomination_rec_nonrep(coins, coins.length, sum));
        System.out.println();
        Denominations_dp_tab(coins, sum, coins.length);
        System.out.println();
        //best Solution - PepCoding Video
        Denominations_dp(coins, sum);

        System.out.println();
        System.out.println("Perm");
        Denomination_dp_perm(coins, sum);

    }
    static void Denominations_rec(int[] coins, int sum, int curr_sum, String ans){
        //base case
        if(curr_sum>sum){return;}
        if(curr_sum == sum){
            soln++;
            return;
        }
        for(int i = 0; i<coins.length; i++) {
            Denominations_rec(coins, sum, curr_sum + coins[i], ans + "");
        }
    }//This soln provides repetitive answers(Permutations whereas Combinations are needed)

    static int Denomination_rec_nonrep(int[] coins, int n, int sum){
        //base cases
        if(sum == 0) return 1;
        if(n==0) return 0;
        //recursion
            //Not Including the last coin
        int res = Denomination_rec_nonrep(coins, n-1, sum);
            //Including the last coin if it is less than sum
        if(coins[n-1]<=sum){
            res += Denomination_rec_nonrep(coins, n, sum-coins[n-1]);
        }
        return res;
    }
    static void Denominations_dp_tab(int[] coins, int sum, int n){
        int[][] dp = new int[sum+1][n+1];
        for(int i = 0; i<=sum; i++){dp[i][0] = 0;}
        for(int j = 0; j<=n; j++){dp[0][j] = 1;}

        for(int i = 1; i<=sum; i++){
            for(int j = 1; j<=n; j++){
                dp[i][j] = dp[i][j-1];
                if(coins[j-1]<=i){
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }

        System.out.println(dp[sum][n]);
    }
    static void Denominations_dp(int[] coins, int sum){
        int n = coins.length;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 0; i<n ; i++){
            for(int j = coins[i]; j<=sum; j++){
                dp[j] += dp[j-coins[i]];
            }
        }
        System.out.println(dp[dp.length-1]);
    }
    static void Denomination_dp_perm(int[] coins, int sum){
        int dp[] = new int[sum+1];
        dp[0] = 1;
        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<coins.length; j++){
                if(coins[j] <= i){
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        System.out.println(dp[dp.length-1]);
    }
}

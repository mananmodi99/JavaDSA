package Backtracking;

public class CoinChangeCode {
    public static void main(String[] args) {
        int denom[] = {2,3,5,6};
        CoinChangePermutation(denom, 10, "");
        CoinChangeCombination(denom, 10, "", 0);
    }
    public static void CoinChangePermutation(int denoms[],int amt,String ans){
        //base
        if(amt == 0){
            System.out.println(ans);
            return;
        }
        if(amt<0)
            return;
        //recursive
        for(int i = 0; i<denoms.length; i++){
            CoinChangePermutation(denoms, amt - denoms[i], ans+denoms[i]);
        }
    }
    public static void CoinChangeCombination(int denoms[],int amt,String ans, int lastDenomIdx){
        //base
        if(amt == 0){
            System.out.println(ans);
            return;
        }
        if(amt<0)
            return;
        //recursive
        for(int i = lastDenomIdx; i<denoms.length; i++){
            CoinChangeCombination(denoms, amt - denoms[i], ans+denoms[i], i);
        }
    }
}

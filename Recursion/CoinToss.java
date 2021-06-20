package Recursion;

public class CoinToss {
    public static void main(String[] args) {
        String abc = "";
        CoinToss(3, abc);
        //System.out.println(abc);
    }
    public static void CoinToss(int n, String abc){
        if(n==0){
            System.out.println(abc);
            return;}
        CoinToss(n-1, abc + "H");
        CoinToss(n-1, abc + "T");
    }
}

package Recursion;

public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbStairs(0, 5, "");
    }
    public static void ClimbStairs(int current, int n, String ans){
        if(current == n){
            System.out.println(ans);
        }
        if(current >= n){
            return;
        }
        ClimbStairs(current+1, n, ans + "1");
        ClimbStairs(current+2, n, ans + "2");
        ClimbStairs(current+3, n, ans + "3");

    }
}

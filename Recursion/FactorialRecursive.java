package Recursion;

public class FactorialRecursive {
    public static void main(String[] args) {
        System.out.println(fact(6));
    }
    public static int fact(int n){
        int fact;
        if(n==1){
            return 1;
        }
        fact = n * fact(n - 1);
        return fact;
    }
}

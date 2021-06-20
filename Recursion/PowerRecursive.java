package Recursion;

public class PowerRecursive {
    public static void main(String[] args) {
        System.out.print(power(10,2));
    }
    public static int power(int x,int n){
        if(x==1){
            return n;
        }
        int power = n*power(x-1, n);
        return power;
    }
}

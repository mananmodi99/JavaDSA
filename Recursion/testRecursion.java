package Recursion;

public class testRecursion {
    public static void PI(int n){
        if(n==0)
            return;
        if(n%2!=0)
            System.out.println(n);
        PI(n-1);
        if(n%2 == 0)
            System.out.println(n);
    }
    public static void main(String[] args) {
        PI(5);
    }
}

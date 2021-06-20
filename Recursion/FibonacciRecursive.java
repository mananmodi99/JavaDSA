package Recursion;
//Very Bad Code. No Optimization at all. Can be Optimized using Dynamic Programming
public class FibonacciRecursive {
    public static void main(String[] args){
        for(int i = 0; i<8; i++)
            System.out.println(FiboTerm(i));
    }
    public static int FiboTerm(int n){
        if(n==0 || n==1){
            return n;
        }
        return (FiboTerm(n-2) + FiboTerm(n-1));
    }
}

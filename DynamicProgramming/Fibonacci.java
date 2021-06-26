import java.io.*;
import java.util.*;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n+1];
		Arrays.fill(arr, -1);
		System.out.println(fib(arr, n));
		for(int i: arr){
			System.out.print(i + ", ");
		}
	}
	static int fib(int[] memo, int n){
		int res;
		if(memo[n] == -1){
			if(n == 0 || n == 1) res = n;
			else res = fib(memo, n-1)+fib(memo, n-2);
			memo[n] = res;
		}
		return memo[n];
	} 
}
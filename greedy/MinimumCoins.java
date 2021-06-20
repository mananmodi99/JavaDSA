import java.io.*;
import java.util.*;

public class MinimumCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int amount = sc.nextInt();
		int[] denominations = {5, 10, 2, 3};
		System.out.println(OptimizeCoins(denominations, amount));
	}
	static String OptimizeCoins(int[] coins, int amount){
		Arrays.sort(coins);
		String res = "";
		for(int i = coins.length-1; i>=0; i--){
			if(coins[i]<=amount){
				int nums = (int) Math.floor(amount/coins[i]);
				res += coins[i] + " = " + nums + " , ";
				amount = amount - coins[i]*nums;
			}
			if(amount == 0) return res;
		}
		return res;
	}
}
import java.io.*;
import java.util.*;
class Pair{
	int deadline, profit;
	Pair(int deadline, int profit){
		this.deadline = deadline;
		this.profit = profit;
	}
	int getDeadline(){return deadline;}
	int getProfit(){return profit;}
}
public class JobSequencing {
	public static void main(String[] args) {
		Pair[] arr = new Pair[5];
		arr[0] = new Pair(2, 100);
		arr[1] = new Pair(1, 50);
		arr[2] = new Pair(3, 10);
		arr[3] = new Pair(2, 30);
		arr[4] = new Pair(1, 20);
		int total = 0;
		Arrays.sort(arr, new Comparator<Pair>(){
			@Override
			public int compare(Pair p1, Pair p2){
				return p2.getProfit() - p1.getProfit();
			}
		});

		for(Pair p : arr){
			System.out.println("( " + p.getDeadline() + "," + p.getProfit() + " )");
		}


		boolean[] job = new boolean[arr.length];
		for(int i = 0; i<arr.length; i++){
			for(int j = arr[i].getDeadline()-1; j>=0; j--){
				//Latest Available slot
				if(job[j] == false){
					job[j] = true;
					total += arr[i].getProfit();
					break;
				}
			}
		}
		System.out.println(total);
	}
}
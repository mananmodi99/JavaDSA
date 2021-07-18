package greedy;

import java.io.*;
import java.util.*;
class Pair{
	int weight, value;
	Pair(int weight, int value){
		this.weight = weight;
		this.value = value;
	}
	int getWeight(){
		return this.weight;
	}
	int getValue(){
		return this.value;
	}
	int factor(){
		return (int) this.value/this.weight;
	}

}
public class FractionalKnapsack {
	public static void main(String[] args) {
		Pair[] bags = new Pair[3];
		bags[0] = new Pair(50, 600);
		bags[1] = new Pair(20, 500);
		bags[2] = new Pair(30, 400);
		int requirement = 70;
		Arrays.sort(bags, new Comparator<Pair>(){
			@Override
			//decreasing order
			public int compare(Pair p1, Pair p2){ return p2.factor() - p1.factor(); }
		});
		for(Pair p: bags){
			System.out.println(p.getWeight() + ", " + p.getValue());
		}

		int res = 0;
		for(int i = 0; i<bags.length; i++){
			if(bags[i].getWeight() <= requirement){
				res+=bags[i].getValue();
				requirement -= bags[i].getWeight();
			}
			else{
				res += (int) bags[i].getValue()*((float) requirement/bags[i].getWeight());
				break;
			}
		}
		System.out.println(res);	
	}
}
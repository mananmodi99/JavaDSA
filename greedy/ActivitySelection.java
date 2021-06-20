import java.io.*;
import java.util.*;
class Pair{
	int start;
	int end;
	public Pair(int start, int end){
		this.start = start;
		this.end = end;
	}
	public Pair() {}
	public int getStart(){ return this.start;	}
	public int getEnd(){ return this.end;	}
}
public class ActivitySelection {
	public static void main(String[] args) {
		//ActivitySelection act = new ActivitySelection();
		Pair[] activity = new Pair[4];
		activity[0] = new Pair(2, 3);	
		activity[1] = new Pair(1, 4);	
		activity[2] = new Pair(5, 8);	
		activity[3] = new Pair(56, 100);
		Arrays.sort(activity, new Comparator<Pair>(){
			@Override
			public int compare(Pair p1, Pair p2){return p1.getEnd() - p2.getEnd();}
		});	
		for(Pair p : activity){
			System.out.println("( " + p.getStart() + "," + p.getEnd() + " )");
		}
		ArrayList<Pair> soln = new ArrayList<>();
		soln.add(activity[0]);
		for(int i = 1; i<activity.length; i++){
			if(soln.get(soln.size()-1).getEnd() <= activity[i].getStart()){
				soln.add(activity[i]);
			}
		}
		System.out.println(soln.size()); 	
	}
}
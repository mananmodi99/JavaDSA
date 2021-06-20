import java.util.*;
class triplet implements Comparable<triplet>{
		int value;
		int aPos;
		int vPos;
		triplet(int value, int aPos, int vpos){
			this.value = value;
			this.aPos = aPos;
			this.vPos = vpos;
		}
		public int compareTo(triplet t){
			if(value<=t.value) return -1;
			else return 1;
		}
	}
class MergeKArrays {
	public static void main(String[] args){
		int arr[][] = {{10,20},{5,15},{4,9,11}};
		ArrayList<Integer> res = new ArrayList<Integer>();
		PriorityQueue<triplet> pq = new PriorityQueue<>();
		for(int i = 0; i<arr.length; i++)
		{
			pq.add(new triplet(arr[i][0], i, 0));
		}
		while(pq.isEmpty() == false){
			triplet curr = pq.poll();
			res.add(curr.value);
			int ap = curr.aPos, vp = curr.vPos;
			if(vp+1<arr[ap].length){
				pq.add(new triplet(arr[ap][vp+1], ap, vp+1));
			}
		}
		System.out.println(res);
	}
}
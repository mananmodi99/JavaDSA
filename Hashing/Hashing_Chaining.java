import java.util.*;

public class Hashing_Chaining {
	int bucket; 
	ArrayList<LinkedList<Integer>> table;
	Hashing_Chaining(int m){
		bucket = m;
		table = new ArrayList<>();
		//create an Empty LinkedList in each Slot 
		for(int i = 0; i<m; i++)
			table.add(new LinkedList<Integer>());
	}
	void insert(int key){
		int index = key%bucket;
		table.get(index).add(key);
	}
	
	void delete(int key){
		int index = key%bucket;
		table.get(index).remove((Integer)key);//Typecast Karna is important else it'll try to remove the key index from the Table 
	}
	boolean search(int key){
		int index = key%bucket;
		return table.get(index).contains(key);
	}
	public static void main(String[] args) {
		int keys[] = {50,21,58,17,15,49,56,22,23,25};
		Hashing_Chaining hashChain = new Hashing_Chaining(7);
		for(int i = 0; i<keys.length; i++){
			hashChain.insert(keys[i]);
		}
		System.out.println(hashChain.search(59));
	}   
}
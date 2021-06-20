//package Hashing;
import java.util.*;

public class HashingOpenAddressing {
	int capacity, size;
	int[] table;
	HashingOpenAddressing(int m){
		capacity = m;
		table = new int[m];
		Arrays.fill(table, -1);
	}
	boolean insert(int key){
		int probe = key%capacity;
		if(size==capacity){
			return false;
		}
		while(table[probe] != -1 && table[probe] != -2 && table[probe] != key){
			probe = (probe+1)%capacity;
		}
		if(table[probe] == key) 
			return false;
		table[probe] = key;
		size++;
		return true;

	}
	boolean search(int key){
		int probe = key%capacity;
		int h1 = table[probe];
		while(table[probe] != -1){
			if(table[probe] == key)
				return true;
			probe = (probe+1)%capacity;
			if(table[probe] == h1)
				return false;
		}
		return false;
	}
	boolean erase(int key){
		int probe = key%capacity;
		int h1 = table[probe];
		while(table[probe] != -1){
			if(table[probe] == key){
				table[probe] = -2;
				return true;}
			probe = (probe+1)%capacity;
			if(table[probe] == h1)
				return false;
		}
		return false;
	}
	void display(){
		for(int i = 0; i<table.length; i++)
			System.out.print(table[i]+" ");
		System.out.println("END");
	}
	public static void main(String[] args) {
		
		HashingOpenAddressing mh = new HashingOpenAddressing(7);
		
		mh.insert(49);
	    mh.insert(56);
	    mh.insert(72);
	    mh.display();
	    if(mh.search(56)==true)
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	    mh.erase(56);
	    mh.display();
	    mh.insert(57);
	    mh.display();
	    if(mh.search(56)==true)
	        System.out.println("Yes");
	    else
	        System.out.println("No");
	}
    
}
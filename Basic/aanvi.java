import java.io.*;
import java.util.*;

public class aanvi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ramu = sc.nextInt();
		int arr[] = new int[ramu];
		for(int i = 0; i<ramu; i++)
			arr[i] = sc.nextInt();
		int vinay = sc.nextInt();
		int sum = 0;
		boolean check = false;
		for(int i = 0; i<arr.length; i++){
			for(int j = i+1; j<arr.length; j++){
				if(arr[i] + arr[j] == vinay){
					check = true;
					System.out.println(arr[i] + "," + arr[j]);
				}
			}
		}
		if(check == false){
			System.out.println("No perfect couple found!");
		}
	}
}
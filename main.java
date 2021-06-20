import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("input.txt"));
			System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		} catch (Exception e) {
			System.err.println("Error");
		}
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(n);
		System.out.println();
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(0);
		arr.add(0);
		System.out.println(arr.get(arr.size()-1));
	}
}
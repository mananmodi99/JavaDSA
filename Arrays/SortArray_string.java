package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray_string {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();;
        String[] strings = new String[n];
        for(int i=0;i<n; i++){
            strings[i] = sc.next();
        }
        Arrays.sort(strings);

        for (int i=1; i<n; i++) {
            if(strings[i].contains(strings[i-1])){
                String temp = strings[i-1];
                strings[i-1] = strings[i];
                strings[i] = temp;
            }
        }
        for (String str :strings
        ) {
            System.out.println(str);
        }
    }
}

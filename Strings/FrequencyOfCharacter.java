package Strings;

import java.util.Scanner;

public class FrequencyOfCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = new String(sc.next());
        boolean arr[] = new boolean[s.length()];
        int count = 0;
        int max_till_now = 0;
        for(int i=0; i<s.length(); i++){
            if(arr[i]== true){
                continue;
            }
            else{
                for(int j=0; j<s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        count++;
                        arr[j] = true;
                    }
                }
            }
            System.out.println(s.charAt(i) + "  " + count);
            count = 0;
        }
    }
}

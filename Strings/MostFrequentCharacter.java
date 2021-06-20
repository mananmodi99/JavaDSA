package Strings;

import java.util.Scanner;

public class MostFrequentCharacter {
    public static void Frequency(String s){
        int alphabets[] = new int[26];
        for(int i=0; i<s.length(); i++){
            int ascii = (int) s.charAt(i);
            alphabets[ascii-97]++;
        }
        int curr_max_index = Integer.MIN_VALUE;
        int frequent = 0;
        for(int i=0; i<alphabets.length; i++){
            if(alphabets[i]>curr_max_index){
                System.out.println();
                System.out.println("Loop Entered at " + i);
                curr_max_index = alphabets[i];
                frequent = i;
            }
        }
        System.out.println((char) (frequent+97));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Frequency(s);
    }
}

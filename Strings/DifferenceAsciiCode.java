package Strings;

import java.util.Scanner;

public class DifferenceAsciiCode {
    public static int AsciiDifference(char begin, char end){
        return ((int) end - (int) begin);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length()-1; i++){
            sb.append(s.charAt(i));
            sb.append(AsciiDifference(s.charAt(i), s.charAt(i+1)));
        }
        sb.append(s.charAt(s.length()-1));
        System.out.println(sb);
    }
}
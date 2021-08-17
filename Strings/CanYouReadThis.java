//package Strings;

import java.util.Scanner;

public class CanYouReadThis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i=0; i<s.length(); i++){
            int ascii = (int) s.charAt(i);
            if(i!=0 && ascii >= 65 && ascii <= 90){
                System.out.println();
                System.out.print(s.charAt(i));
            }
            else{
                System.out.print(s.charAt(i));
            }
        }        
    }
    
}

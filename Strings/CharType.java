package Strings;

import java.util.Scanner;

public class CharType {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        if(ch >= 'a' && ch <= 'z'){
            System.out.println("L");
        }
        else if(ch >= 'A' && ch <= 'Z'){
            System.out.println("U");
        }
        else{
            System.out.println("I");
        }
    }
}

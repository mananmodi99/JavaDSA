package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class Dialpad {
    public static String getCode(char ch){
        switch(ch){
            case '1':
                return "abc";
            case '2':
                return "def";
            case '3':
                return "ghi";
            case '4':
                return "jkl";
            case '5':
                return "mno";
            case '6':
                return "pqrs";
            case '7':
                return "tuv";
            case '8':
                return "wx";
            case '9':
                return "yz";
            default:
                return "";
        }
    }
    public static void PhonePattern(String num, String ans, ArrayList<String> array){
        //base
        if(num.length()==0){
            array.add(ans);
            return;
        }

        //recursive
        char ch = num.charAt(0);
        String numUpdate = num.substring(1);
        String code = getCode(ch);
        for(int i=0; i<code.length(); i++){
            PhonePattern(numUpdate, ans + code.charAt(i), array);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        ArrayList<String> array = new ArrayList<String>();
        PhonePattern(num, "", array);
        for(String c: array)
            System.out.print(c + " ");
        System.out.println();
        System.out.println(array.size());
    }
}

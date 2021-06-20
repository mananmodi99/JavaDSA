package Recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class PossibleStrings {
    public static ArrayList<String> main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ArrayList<String> list = new ArrayList<String>();
        PossibleStrings(str, "", list);
        return list;
    }
    public static void PossibleStrings(String str, String ans, ArrayList<String> list){
        //base
        if(str.length() == 1){
            list.add(ans+str.charAt(0));
            return;
        }
        //recursive
        char ch = str.charAt(0);
        String ros = str.substring(1);
        PossibleStrings(ros, ans +  ch, list);
        PossibleStrings(ros, ans +  ch + " ", list);
    }
}

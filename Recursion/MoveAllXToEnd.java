package Recursion;

import java.util.Scanner;

public class MoveAllXToEnd {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int x = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'x'){
                x++;
            }
        }
        MoveAllXtoEnd(str, "",str.length() , x);
    }
    public static void MoveAllXtoEnd(String str, String ans,int len,int x){
        //base
        if(str.length() == len-x){
            System.out.println(str+ans);
            return;
        }
        //recursive
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == 'x'){
                String strUpdate = str.substring(0,i)+str.substring(i+1);
                MoveAllXtoEnd(strUpdate, ans+"x", len, x);
            }
        }
    }
}

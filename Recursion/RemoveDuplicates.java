package Recursion;

import java.util.Scanner;

public class RemoveDuplicates {
    public static void ReplaceDuplicates(String str,int len, int index, int index1, String ans){
        //base
        if(index1>=len){
            if(index1==len)
                System.out.println(ans+str.charAt(index));
            else
                System.out.println(ans);
            return;
        }
        //recursive
        if(str.charAt(index) != str.charAt(index1)){
            ReplaceDuplicates(str,len, index+1, index1+1, ans+str.charAt(index));
        }
        else{
            ReplaceDuplicates(str,len, index+2, index1+2, ans+str.charAt(index));
        }

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        ReplaceDuplicates(str,str.length(), 0, 1, "");
    }
}

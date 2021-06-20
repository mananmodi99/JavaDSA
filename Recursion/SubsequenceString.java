package Recursion;

public class SubsequenceString {
    public static void main(String[] args) {
        Subsequences("abc", "");
    }
    public static void Subsequences(String str, String ans){
        //Base
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //Recursive
        char first = str.charAt(0);
        String ros = str.substring(1);
            //case-1:Not including first char
        Subsequences(ros, ans);
            //case-2:Including first char
        Subsequences(ros, ans+first);
    }
}

package Recursion;

import java.util.ArrayList;

public class getPermutation {
    public static void main(String[] args) {
        System.out.println(permutations("abc"));

    }
    public static ArrayList<String> permutations(String str){
        if(str.length() == 0){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        char first = str.charAt(0);
        String restOfString = str.substring(1);
        ArrayList<String> recursive = permutations(restOfString);
        ArrayList<String> result = new ArrayList<>();
        for(String currElems:recursive){
            for(int i=0; i<=currElems.length(); i++){
                String strUpdate = currElems.substring(0,i) + first + currElems.substring(i);//insertion
                result.add(strUpdate);
            }
        }
        return result;
    }
}

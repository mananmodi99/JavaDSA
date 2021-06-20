package Arrays;

import java.util.ArrayList;

public class SubsequencesOfAString {
    public static void main(String[] args) {
        String abc = "abc";
        System.out.println(Subsequences(abc));
    }
    public static ArrayList<String> Subsequences(String abc){
        if(abc.isEmpty()){
            ArrayList<String> baseResult = new ArrayList<String>();
            baseResult.add(" ");
            return baseResult;
        }
        char c = abc.charAt(0);
        String bc = abc.substring(1);
        ArrayList<String> myResult = new ArrayList<String>();
        ArrayList<String> Recursive = Subsequences(bc);
        for(int i=0; i<Recursive.size() ; i++){
            myResult.add(Recursive.get(i));
            myResult.add(c + Recursive.get(i));
        }
        return myResult;
    }

}

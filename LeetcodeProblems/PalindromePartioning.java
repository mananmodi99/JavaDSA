package LeetcodeProblems;
import java.util.*;
public class PalindromePartioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> mainList = new ArrayList<>();
        InsertPalindrome(s, "", new ArrayList<String>(), mainList);
        return mainList;

    }
    public static void InsertPalindrome(String str, String sub, List<String> list, List<List<String>> mainList){
        if(str.length() == 0){
            mainList.add(new ArrayList<String>(list));
            return;
        }
        for(int i = 0; i<str.length(); i++){
            sub = str.substring(0,i+1);
            String ros = str.substring(i+1);
            if(isPalindrome(sub)){
                list.add(sub);
                InsertPalindrome(ros, sub, list, mainList);
                list.remove(list.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int lo = 0;
        int hi = s.length()-1;
        while(lo<=hi){
            if(s.charAt(lo) == s.charAt(hi)){lo++; hi--;}
            else{return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> mainList = new ArrayList<>();
        mainList = partition("abaaba");
        System.out.println(mainList);
    }
}

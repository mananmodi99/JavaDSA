package Recursion;

import java.util.*;

public class DictionaryOrder {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        StringBuilder sb = new StringBuilder();
        for (char c : strArr) {
            sb.append(c);
        }
        String str1 = sb.toString();
//        System.out.println(str);
        PermutationStr(str1, str, "");
    }

    private static void PermutationStr(String str, String str1, String ans) {
        //base
        if(str.length() == 0){
            if(ans.compareTo(str1)<0)
                System.out.println(ans);
            return;
        }
        //recursive
        for(int i = 0; i<str.length(); i++){
            String strupdate = str.substring(0,i)+str.substring(i+1);
            PermutationStr(strupdate, str1, ans+str.charAt(i));
        }
    }
}

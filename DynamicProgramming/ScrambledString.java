package DynamicProgramming;
import java.util.*;
public class ScrambledString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        if(s1.length() == 0 || s2.length() == 0) return false;
        return checkScmbl(s1, s2, new HashMap<String, Boolean>());
    }
    public boolean checkScmbl(String s1, String s2, HashMap<String, Boolean> map){

        if(s1.compareTo(s2) == 0) return true;
        String temp = s1+" "+s2;
        boolean flag = false;
        if(!map.containsKey(temp)){
            for(int i = 1; i<=s1.length()-1; i++){
                boolean swap = checkScmbl(s1.substring(0,i), s2.substring(s1.length()-i), map) && checkScmbl(s1.substring(i), s2.substring(0,s1.length()-i), map);
                boolean noSwap = checkScmbl(s1.substring(0,i), s2.substring(0,i), map) && checkScmbl(s1.substring(i), s2.substring(i), map);
                if(swap || noSwap){
                    flag = true;
                    break;
                }
            }
            map.put(temp, flag);
        }

        return map.get(temp);
    }
}

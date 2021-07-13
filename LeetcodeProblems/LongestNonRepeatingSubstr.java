package LeetcodeProblems;

import java.util.HashSet;

public class LongestNonRepeatingSubstr {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcaaab"));
    }
    public static int lengthOfLongestSubstring(String s) {

        public int lengthOfLongestSubstring(String str) {
            HashSet<Integer> set = new HashSet<>();
            int max_len = 0;
            int lo = 0, hi = 0;
            char[] s = str.toCharArray();
            while(lo<s.length && hi<s.length){
                if(!set.contains((int) s[hi])){
                    set.add((int) s[hi]);
                    max_len = Math.max(hi-lo+1, max_len);
                    hi++;
                }
                else{
                    set.remove((int) s[lo]);
                    lo++;
                }
            }
            //max_len = Math.max(hi-lo+1, max_len);
            return max_len;
        }
    }
}

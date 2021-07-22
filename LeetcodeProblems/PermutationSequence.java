package LeetcodeProblems;
import java.util.*;
public class PermutationSequence {
    public static void main(String[] args) {
        int n = 3, k = 3;
        String str = "";
        for(int i = 1; i<n+1; i++){
            str = str + i;
        }
        List<String> ans = new ArrayList<>();
        Permutation(str, "", ans, n);
        System.out.println(ans.get(k+1));

    }
    public static void Permutation(String str, String curr, List<String> ans, int n) {
        //base
        if (str.length() == 0) {
            ans.add(curr);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            String ros = str.substring(0, i) + str.substring(i + 1);
            Permutation(ros, curr + str.charAt(i), ans, n);
        }

        //recursion
    }
}

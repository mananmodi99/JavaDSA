package Strings;
import java.util.*;
import java.lang.*;
public class SanketAndStrings {
    public static int MaxSwaps(String s, int n, char c){
        int left = 0, right, swapsCurrentlyPossible = 0, ans = 0;
        for(right=0; right<s.length()-1; right++){
            if(s.charAt(right) != c){
                swapsCurrentlyPossible++;
            }
            if(swapsCurrentlyPossible == n){
                break;
            }
        }
        while(left<right)
        {
            while(right+1<s.length() && s.charAt(right+1) == c)
                right++;
            int CurrentAns = right-left+1;
            ans = Math.max(ans,CurrentAns);
            left++;
            if(right+1<s.length() && s.charAt(left-1) != c) {
                right++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        if(n > s.length()) {
            System.out.println(s.length());
        }
        else{
            int a = MaxSwaps(s, n, 'a');
            int b = MaxSwaps(s, n, 'b');
            System.out.println(Math.max(a, b));
        }
    }
}

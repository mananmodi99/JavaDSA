package Strings;
import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toLowerCase();
        boolean isPalindrome = false;

        int left = 0, right = s.length()-1;
        while(left<=right){
            if(s.charAt(left) == s.charAt(right)){
                isPalindrome = true;
                left++;
                right--;
            }
            else{
                isPalindrome = false;
                break;
            }
        }
        System.out.println(isPalindrome);
    }
}

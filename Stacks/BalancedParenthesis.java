package Stacks;
import java.util.*;
public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(checkParenthesis(s));
    }
    public static boolean checkParenthesis(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
               stack.push(s.charAt(i));
            }
            else if(stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')){
                return false;
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if(s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if(s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }

        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}

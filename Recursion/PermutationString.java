package Recursion;

public class PermutationString {
    public static void main(String[] args) {
        Permutations("abc", "");
    }
    public static void Permutations(String abc, String ans){
        if(abc.length() == 0){
            System.out.println(ans);
            return;
        }
        for(int i=0; i< abc.length(); i++){
            String abcUpdate = abc.substring(0,i)+abc.substring(i+1);
            Permutations(abcUpdate, ans + abc.charAt(i));
        }
    }
}

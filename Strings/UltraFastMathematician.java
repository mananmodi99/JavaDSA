package Strings;

import java.util.Scanner;

public class UltraFastMathematician {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String str1 = sc.next();
            String str2 = sc.next();
            StringBuilder AnsStr = new StringBuilder();
            for(int i=0; i<str1.length(); i++){
                if(str1.charAt(i) == str2.charAt(i)){
                    AnsStr.append("0");
                }
                else
                    AnsStr.append("1");
            }
            System.out.println(AnsStr);
        }
    }
}

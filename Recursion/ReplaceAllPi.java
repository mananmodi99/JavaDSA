package Recursion;

import java.util.Scanner;

public class ReplaceAllPi {
    public static void ReplaceAllPi(String str, int index,int index1,int len, String ans){
        //base
        if(index >= len){
            System.out.println(ans);
            return;
        }
        //recursive
        if(str.charAt(index) != 'p'){
            ReplaceAllPi(str, index+1, index1+1,len, ans+str.charAt(index));
        }
        else{
            if(str.charAt(index1) != 'i'){
                ReplaceAllPi(str, index+1, index1+1,len, ans+str.charAt(index));
            }
            else{
                ReplaceAllPi(str, index+2, index1+2,len, ans+"3.14");
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            String str = sc.next();
            ReplaceAllPi(str, 0, 1,str.length(), "");
            System.out.println();
            t--;
        }
    }
}

package Arrays;

import java.util.Scanner;
import java.util.Arrays;

public class StringsAnagram {

    public static void main(String[] args) {
        String a = "bba";
        String b = "abb";
        //method 1
//        boolean visited[] = new boolean[b.length()];
          boolean isAnagram = true;//False for method 1; t for 2;
//        if (a.length() == b.length()) {
//
//            for (int i = 0; i < a.length(); i++) {
//                isAnagram = false;
//                char check = a.charAt(i);
//                for (int j = 0; j < b.length(); j++) {
//                    if (check == b.charAt(j) && !visited[j]) {
//                        isAnagram = true;
//                        visited[j] = true;
//                        break;
//                    }
//
//                }
//                if (isAnagram == false)
//                    break;
//
//            }
//            if (isAnagram == true)
//                System.out.println("Yes!");
//            else
//                System.out.println("Hell No!");
//
//        }

        //Method ----> 2
//        int string1[] = new int[256];//all values are 0
//        int string2[] = new int[256];
//        for (char c: a.toCharArray()
//             ) {
//            int index = (int) c;
//            string1[index]++;
//        }
//        for (char c: b.toCharArray()
//        ) {
//            int index = (int) c;
//            string2[index]++;
//        }
////        if(Arrays.equals(string1,string2))
////            System.out.println("T");
////        else
////            System.out.println("Fs");
//        for (int i=0;i<256;i++){
//            if(string1[i] != string2[i])
//                isAnagram = false;
//        }
//        if (isAnagram == true)
//            System.out.println("Yes!");
//        else
//            System.out.println("Hell No!");

        //Method 3-->

        int string1[] = new int[256];//all values are 0
        for (char c: a.toCharArray()
        ) {
            int index = (int) c;
            string1[index]++;
        }
        for (char c: b.toCharArray()
        ) {
            int index = (int) c;
            string1[index]--;
        }
        for (int check :string1) {
            if(check != 0)
                isAnagram = false;
        }
        if (isAnagram == true)
              System.out.println("Yes!");
        else
              System.out.println("Hell No!");

    }
}

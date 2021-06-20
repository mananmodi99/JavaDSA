package Recursion;

import java.util.ArrayList;

public class BoardPathRecursive {
    public static void main(String[] args){
        int count=0;
        BoardPath(0, 0, "");
        System.out.println("Size = " + BoardPathCount(0, 0) + " Arraylist : " + BoardPathArrayList(0, 0).size());
    }
    public static void BoardPath(int start, int n, String ans){
        if(n==10){
            System.out.println(ans);
        }
        if(n>10){//negative base cases
            return;
        }

        for(int dice=1; dice<=6; dice++) {
            BoardPath(start, n + dice, ans + dice);
        }

    }

    public static ArrayList<String> BoardPathArrayList(int start, int current){
        //Base-Case
        if(current == 10){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        if(current > 10){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        //Recursive
        ArrayList<String> myResult = new ArrayList<>();
        for(int dice = 1; dice<=6; dice++){
            ArrayList<String> recursiveResult = BoardPathArrayList(start, current+dice);
            for(String recStr: recursiveResult)
                myResult.add(dice+recStr);
        }
        return myResult;
    }

    public static int BoardPathCount(int start, int n){
        if(n==10){
            return 1;
        }
        if(n>10){//negative base cases
            return 0;
        }
        int count = 0;
        for(int dice=1; dice<=6; dice++) {
            count += BoardPathCount(start, n + dice);
        }
    return count;
    }
}

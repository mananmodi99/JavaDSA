package Recursion;

import java.util.ArrayList;

public class getMazePath {
    public static void main(String[] args) {
        //System.out.println(MazePathDiag(0,0));
        //System.out.println();
        MazePathPrint(0,0, "");
        System.out.println(MazePathPrintCount(0,0));
    }
    public static ArrayList<String> MazePath(int row, int col){
        //Base-Case
        if(row==2 && col==2){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        if(row>2 || col>2){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        //Recursion
        ArrayList<String> RecursiveRes1 = MazePath(row+1, col);
        ArrayList<String> RecursiveRes2 = MazePath(row, col+1);
        ArrayList<String> myResult = new ArrayList<>();
        for(String rrs1: RecursiveRes1)
            myResult.add("H"+rrs1);

        for(String rrs2: RecursiveRes2)
            myResult.add("V"+rrs2);

        return myResult;
    }

    public static ArrayList<String> MazePathDiag(int row, int col){
        //Base-Case
        if(row == 2 && col == 2){
            ArrayList<String> base = new ArrayList<>();
            base.add(" ");
            return base;
        }
        if(row>2 || col>2){
            ArrayList<String> base = new ArrayList<>();
            return base;
        }
        //Recursion
        ArrayList<String> RecursiveRes1 = MazePathDiag(row+1, col);
        ArrayList<String> RecursiveRes2 = MazePathDiag(row, col+1);
        ArrayList<String> RecursiveRes3 = MazePathDiag(row+1, col+1);

        ArrayList<String> myResult = new ArrayList<>();
        for(String rrs1: RecursiveRes1)
            myResult.add("H"+rrs1);

        for(String rrs2: RecursiveRes2)
            myResult.add("V"+rrs2);

        for(String rrs3: RecursiveRes3)
            myResult.add("D"+rrs3);

        return myResult;
    }

    public static void MazePathPrint(int row, int col, String ans){

        if(row == 2 && col == 2){
            System.out.println(ans);
        }
        if(row > 2 || col > 2){
            return;
        }
        MazePathPrint(row + 1, col, ans + "H");
        MazePathPrint(row, col + 1, ans + "V");
        MazePathPrint(row + 1, col + 1, ans+ "D");
    }

    public static int MazePathPrintCount(int row, int col){

        if(row == 2 && col == 2){
            return 1;

        }
        if(row > 2 || col > 2){
            return 0;
        }
        int count = 0;
        count += MazePathPrintCount(row + 1, col);
        count += MazePathPrintCount(row, col + 1);
        count += MazePathPrintCount(row + 1, col + 1);
        return count;
    }
}

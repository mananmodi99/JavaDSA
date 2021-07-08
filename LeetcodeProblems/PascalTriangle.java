package LeetcodeProblems;
import java.util.*;
//Problem Link: https://leetcode.com/problems/next-permutation/
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list= new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        for(int rows = 0; rows<numRows; rows++){
            row = new ArrayList<>();
            for(int idx = 0; idx<=rows; idx++){
                if(idx == 0 || idx == rows) row.add(1);
                else{
                    row.add(prev.get(idx-1)+prev.get(idx));
                }
            }
            prev = row;
            list.add(row);
        }
        return list;
    }
}

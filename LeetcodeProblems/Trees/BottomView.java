package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BottomView {
    ArrayList<Integer> BottomView(Node root){
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> bottom = new ArrayList<>();
        int[] width = new int[2];
        for(int i= 0; i<width[1]-width[0]+1; i++)
            bottom.add(Integer.MAX_VALUE-100);
        int level = Math.abs(width[0]);
        q.add(new Pair(root, level));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            level = p.level;
            bottom.set(level, curr.data);
            if(curr.left!=null) q.add(new Pair(curr.left, level-1));
            if(curr.right!=null) q.add(new Pair(curr.right, level+1));
        }
        return bottom;
    }
}

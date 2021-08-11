package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopView {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public ArrayList<Integer> topView(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        ArrayList <Integer> top = new ArrayList<>();
        if(root == null) return top;
        int[] width = new int[2];
        for(int i= 0; i<width[1]-width[0]+1; i++)
            top.add(Integer.MAX_VALUE-100);
        int level = Math.abs(width[0]);
        q.add(new Pair(root, Math.abs(min)));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                Pair p = q.poll();
                Node curr = p.node;
                level = p.level;
                if(top.get(level) == Integer.MIN_VALUE)
                    top.set(level, curr.data);
                if(curr.left!=null) q.add(new Pair(curr.left, level-1));
                if(curr.right!=null) q.add(new Pair(curr.right, level+1));
            }
        }
        return top;
    }
}

package LeetcodeProblems.Trees;

import java.util.*;

class Pair{
    Node node;
    int level;
    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}
public class VerticalTraversal {
    ArrayList<Integer> verticalOrder(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        q.add(new Pair(root, 0));
        int min_level = Integer.MAX_VALUE;
        int max_level = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int level = p.level;
            map.putIfAbsent(level, new ArrayList<Integer>());
            map.get(level).add(curr.data);
            if(curr.left!=null) q.add(new Pair(curr.left, level-1));
            if(curr.right!=null) q.add(new Pair(curr.right, level+1));
            max_level = Math.max(max_level, level);
            min_level = Math.min(min_level, level);
        }
        for(int i = min_level; i<=max_level; i++){
            for(int elem : map.get(i))
                list.add(elem);
        }
        return list;
    }
    ArrayList<ArrayList<Integer>> VerticalTraversalofBTM2(Node root){
        Queue<Pair> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] width = new int[2];
        for(int i= 0; i<width[1]-width[0]+1; i++)
            list.add(new ArrayList<Integer>());
        int level = Math.abs(width[0]);
        q.add(new Pair(root, level));
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            level = p.level;
            list.get(level).add(curr.data);
            if(curr.left!=null) q.add(new Pair(curr.left, level-1));
            if(curr.right!=null) q.add(new Pair(curr.right, level+1));
        }
        return list;
    }
}

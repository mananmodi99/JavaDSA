package LeetcodeProblems.Trees;

import java.util.*;

public class RightView {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        q.add(new Pair(root, 0));
        int min_level = Integer.MAX_VALUE;
        int max_level = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode curr = (TreeNode) p.node;
            int level = p.level;
            map.putIfAbsent(level, new ArrayList<Integer>());
            map.get(level).add(curr.val);
            if(curr.left!=null) q.add(new Pair(curr.left, level-1));
            if(curr.right!=null) q.add(new Pair(curr.right, level+1));
            max_level = Math.max(max_level, level);
            min_level = Math.min(min_level, level);
        }
        for(int i = min_level; i<=max_level; i++){
            list.add(map.get(i));
        }
        return list;
    }
}

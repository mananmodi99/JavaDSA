package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrderM1(TreeNode root) {
        List<List<Integer>> soln = new ArrayList<>();
        if(root == null) return soln;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();//VIMP - Size would keep changing
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                list.add(curr.val);
            }
            soln.add(new ArrayList<>(list));
            list.clear();
        }
        return soln;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> soln = new ArrayList<>();
        if(root == null) return soln;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> list = new ArrayList<>();
        while(q.size()>=1){
            TreeNode curr = q.poll();
            if(curr != null){
                list.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);

            }else{
                q.add(null);
                soln.add(new ArrayList<>(list));
                list = new ArrayList();
                if(q.peek() == null){
                    break;
                }

            }
        }
        return soln;
    }
}

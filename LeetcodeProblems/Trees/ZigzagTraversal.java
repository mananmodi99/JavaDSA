package LeetcodeProblems.Trees;

import java.util.*;

import static javax.swing.Spring.height;

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        q.add(root);
        boolean l2r = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreeNode curr = q.poll();
                if(!l2r){
                    st.push(curr);
                }
                else{
                    currList.add(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            l2r = !l2r;
            while(!st.isEmpty())
                currList.add(st.pop().val);
            list.add(currList);
        }
        return list;
    }




    //recursive
    public void spiralPrint_rec(TreeNode root){
        boolean l2r = false;
        int h = height(root);
        for(int i = 1; i<=h; i++){
            spiralPrint_recClient(root, i, l2r);
            l2r = !l2r;
        }
    }
    public void spiralPrint_recClient(TreeNode root, int i, boolean l2r){
        if(root == null) return;
        if(i == 1) System.out.println(root.data);
        else{
            if(l2r){
                spiralPrint_recClient(root.left, i-1, l2r);
                spiralPrint_recClient(root.right, i-1, l2r);
            }
            else{
                spiralPrint_recClient(root.right, i-1, l2r);
                spiralPrint_recClient(root.left, i-1, l2r);
            }
        }
    }
}

package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {
    //Recursive
    public List<Integer> inorderTraversal_rec(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrderRec(root, list);
        return list;
    }
    public void inOrderRec(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inOrderRec(root.left, list);
        list.add(root.val);
        inOrderRec(root.right, list);
    }

    //Iterative
    public List<Integer> inorderTraversal_Iter(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }
}

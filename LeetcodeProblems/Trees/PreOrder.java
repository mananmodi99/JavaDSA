package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    //Recursive
    public List<Integer> preorderTraversal_rec(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    //Iterative
    public List<Integer> preorderTraversal_iter(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        st.push(root);
        while(!st.isEmpty()){
            while(curr != null){
                list.add(curr.val);
                if(curr.right != null)
                    st.push(curr.right);
                curr = curr.left;
            }
            curr = st.pop();
        }
        return list;
    }
}

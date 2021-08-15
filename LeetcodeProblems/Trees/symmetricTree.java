package LeetcodeProblems.Trees;

import java.util.Stack;

public class symmetricTree {
    //Recursive
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricClient(root.left, root.right);
    }
    public boolean isSymmetricClient(TreeNode l, TreeNode r){
        if(l == null || r == null) return l==r;
        if(l.val == r.val)
            return isSymmetricClient(l.left, r.right) && isSymmetricClient(l.right, r.left);
        return false;
    }


    //Iterative
    public boolean isSymmetricIter(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root.left == null && root.right == null){return true;}
        if(root.left == null || root.right == null){return false;}
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode l = st.pop();
            TreeNode r = st.pop();
            if(l==null && r==null) continue;
            if(l == null || r == null || l.val!=r.val) return false;
            st.push(l.left);
            st.push(r.right);
            st.push(l.right);
            st.push(r.left);
        }
        return true;
    }
}

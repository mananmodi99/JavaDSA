package LeetcodeProblems.Trees.BST;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class ValidateBST {
    //set boundaries for each node
    public boolean isValidBST(TreeNode root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean checkBST(TreeNode root, long min, long max){
        if(root == null) return true;
        if(root.val < max && root.val > min){
            return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
        }
        return false;
    }

    //extra space
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        for(int i = 1; i<list.size(); i++){
            if(list.get(i-1)>=list.get(i))
                return false;
        }
        return true;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if(root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

package LeetcodeProblems.Trees;

import java.util.HashMap;

public class TreeUsingInOrderAndPreOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTreeClient(preorder, inorder, 0, preorder.length);
        return root;
    }
    int preIdx = 0;
    public TreeNode buildTreeClient(int[] pre, int[] in, int start, int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(pre[preIdx++]);
        int i;
        for(i = start; i<=end; i++){
            if(in[i] == root.val){
                break;
            }
        }
        root.left = buildTreeClient(pre, in, start, i-1);
        root.right = buildTreeClient(pre, in, i+1, end);
        return root;
    }

    //Optimized using map
    public TreeNode buildTreeOpti(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i  = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeClientOpti(preorder, inorder, 0, preorder.length-1, map);
        return root;
    }
    int preIdxOpti = 0;
    public TreeNode buildTreeClientOpti(int[] pre, int[] in, int start, int end, HashMap<Integer, Integer> map){
        if(start>end) return null;
        TreeNode root = new TreeNode(pre[preIdxOpti++]);
        int i = map.get(root.val);
        root.left =  buildTreeClientOpti(pre, in, start, i-1, map);
        root.right = buildTreeClientOpti(pre, in, i+1, end, map);
        return root;
    }
}

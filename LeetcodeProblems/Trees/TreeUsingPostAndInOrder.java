package LeetcodeProblems.Trees;

import java.util.HashMap;

public class TreeUsingPostAndInOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTreeClient(postorder, inorder, 0, postorder.length-1);
        return root;
    }
    int postIdx = 0;
    public TreeNode buildTreeClient(int[] post,int[] in, int start, int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(post[(post.length-1)-postIdx]);
        postIdx++;
        int i;
        for(i = start; i<=end; i++){
            if(in[i] == root.val){
                break;
            }
        }
        root.right = buildTreeClient(post, in, i+1, end);
        root.left = buildTreeClient(post, in, start, i-1);

        return root;
    }


    //Optimized using Map
    public TreeNode buildTreeOpti(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeClientOpti(postorder, inorder, 0, postorder.length-1, map);
        return root;
    }
    int postIdxOpti = 0;
    public TreeNode buildTreeClientOpti(int[] post,int[] in, int start, int end, HashMap<Integer, Integer> map){
        if(start>end) return null;
        TreeNode root = new TreeNode(post[(post.length-1)-postIdxOpti]);
        postIdxOpti++;
        int i = map.get(root.val);
        root.right = buildTreeClientOpti(post, in, i+1, end, map);
        root.left = buildTreeClientOpti(post, in, start, i-1, map);

        return root;
    }
}

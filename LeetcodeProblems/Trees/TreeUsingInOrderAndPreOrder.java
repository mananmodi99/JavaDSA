package LeetcodeProblems.Trees;

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
}

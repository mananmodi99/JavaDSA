package LeetcodeProblems.Trees;

public class MaxPathSum {
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumClient(root);
        return res;
    }
    public int maxPathSumClient(TreeNode root){
        if(root == null) return 0;
        int l = maxPathSumClient(root.left);
        int r = maxPathSumClient(root.right);
        int temp = Math.max(root.val, Math.max(l, r)+root.val);
        int ans = Math.max(l+r+root.val, temp);
        res = Math.max(ans, res);
        return temp;
    }
}

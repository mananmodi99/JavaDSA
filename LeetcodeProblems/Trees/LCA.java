package LeetcodeProblems.Trees;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, LeetcodeProblems.Trees.TreeNode left, LeetcodeProblems.Trees.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LCA {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if(l!=null && r!=null) return root;
        else
        {
            if(l!=null) return l;
            else return r;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(-2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(8);
        root.right = new TreeNode(3);
        System.out.println(lowestCommonAncestor(root, root.left.left.left, root.left.right).val);
    }
}

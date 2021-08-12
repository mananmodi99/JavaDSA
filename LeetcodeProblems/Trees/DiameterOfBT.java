package LeetcodeProblems.Trees;

public class DiameterOfBT {
    class Pair2{
        int dia;
        int height;
        Pair2(){}
        Pair2(int dia, int height){
            this.dia = dia;
            this.height = height;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ldia = diameterOfBinaryTree(root.left);
        int rdia = diameterOfBinaryTree(root.right);
        int temp = 2+height(root.left)+height(root.right);
        return Math.max(temp, Math.max(ldia, rdia));
    }
    public int height(TreeNode root){
        if(root == null) return -1;
        int l = height(root.left);
        int r = height(root.right);
        return Math.max(l,r)+1;
    }



    ///Efficient + Intutive + Avoiding Height Recursion
    public int diameterOfBinaryTree(TreeNode root){
        Pair2 ans = diameterOfBinaryTreeClient(root);
        return ans.dia;
    }
    public Pair2 diameterOfBinaryTreeClient(TreeNode root) {
        if(root == null){
            Pair2 basePair = new Pair(0, -1);
            return basePair;
        }

        Pair2 lp = diameterOfBinaryTreeClient(root.left);
        Pair2 rp = diameterOfBinaryTreeClient(root.right);

        Pair2 diaPair = new Pair2();
        diaPair.height = Math.max(lp.height, rp.height)+1;
        int temp = lp.height+rp.height+2;
        diaPair.dia = Math.max(temp, Math.max(lp.dia, rp.dia));
        return diaPair;
    }
}

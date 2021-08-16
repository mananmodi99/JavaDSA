package LeetcodeProblems.Trees.BST;

import javax.swing.tree.TreeNode;

public class generateBSTfromPreOrder {
    public TreeNode bstFromPreorder(int[] pre) {
        return generateBST(pre, 0, pre.length);
    }
    public TreeNode generateBST(int[] pre, int start, int end){
        if(start>=end) return null;
        TreeNode nn = new TreeNode(pre[start]);
        int k;
        for(k = start; k < end; k++){
            if(pre[start]<pre[k])
                break;
        }
        nn.left = generateBST(pre, start+1, k);
        nn.right = generateBST(pre, k, end);
        return nn;
    }
}

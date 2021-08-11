package LeetcodeProblems.Trees;

import org.w3c.dom.Node;

public class WidthofBT {
    public void widthOfBT(Node root, int[] arr, int level){
        if(root == null) return;
        arr[0] = Math.min(arr[0], level);
        arr[1] = Math.max(arr[1], level);
        widthOfBT(root.left, arr, level-1);
        widthOfBT(root.right, arr, level+1);
    }
}

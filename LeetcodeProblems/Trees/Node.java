package LeetcodeProblems.Trees;

public class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
    }
    Node(int val, Node left, Node right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}

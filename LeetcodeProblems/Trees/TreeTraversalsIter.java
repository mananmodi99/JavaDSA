package LeetcodeProblems.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversalsIter {
    class Pair{
        TreeNode node;
        int state;
        Pair(TreeNode curr, int curr_state){
            node = curr;
            state = curr_state;
        }
    }
    public void InOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(root, 0));
        while(!st.isEmpty()){
            TreeNode curr = st.peek().node;
            int state = st.peek().state;
            if(curr == null){
                st.pop();
                continue;
            }
            if(state == 0){
                st.peek().state++;
                if(curr.left != null){
                    st.push(new Pair(curr.left, 0));
                }
            }
            else if(state == 1){
                st.peek().state++;
                list.add(curr.val);
            }
            else if(state == 2){
                st.peek().state++;
                if(curr.right != null){
                    st.push(new Pair(curr.right, 0));
                }
            }
            else {
                st.pop();
            }
        }
    }
    public static void main(String[] args) {

    }
}

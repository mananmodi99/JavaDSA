package LeetcodeProblems.Trees.BST;
class Res
{
    Node pre = null;
    Node succ = null;
}
public class predecessorAndSuccessorInorder {
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        if(root == null){
            return;
        }
        Node temp;
        if(root.data == key){
            if(root.left != null){
                temp = root.left;
                while(temp.right!=null){
                    temp = temp.right;
                }
                p.pre = temp;
            }
            if(root.right != null){
                temp = root.right;
                while(temp.left != null){
                    temp = temp.left;
                }
                s.succ = temp;
            }
        }
        else if(root.data > key){
            //left side jaana hai
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        }
        else{
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
    }
}

package LeetcodeProblems;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Merge2SortedLL {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        if(l1.val>l2.val){
            ListNode swapper = temp1;
            temp1 = temp2;
            temp2 = swapper;
        }
        ListNode head = temp1;
        ListNode temp = null;
        while(temp1 != null && temp2 != null){
            if(temp1.val<=temp2.val) {
                temp = temp1;
                temp1 = temp1.next;
            }
            else if(temp1.val > temp2.val){
                temp.next = temp2;
                ListNode swapper = temp1;
                temp1 = temp2;
                temp2 = swapper;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode head2 = new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next=new ListNode(4);
        mergeTwoLists(head, head2);

    }
}

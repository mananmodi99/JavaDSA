package LeetcodeProblems;

public class ReverseKNodesLL {
    public static void main(String[] args) {
        ReverseKNodesLL rr = new ReverseKNodesLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(60);
//        head.next.next.next.next.next.next = new ListNode(70);
        printlist(rr.reverseKGroup(head, 3));

    }
    public ListNode reverseKGroup(ListNode head, int k) {
        //ListNode connNode = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode ahead = null;
        int count = 0;
        int size = 1;
        ListNode temp = head;
        while(temp.next!=null){
            size++;
            temp = temp.next;
        }
        int ops = size/k;
        if(ops<=0){ return head;}
        while(curr!=null && count<k){
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
            count++;
        }


        if(curr != null && ops>0){
            ListNode curr_head = reverseKGroup(curr, k);
            head.next = curr_head;
            ops--;
        }

        return prev;
    }
    public static void printlist(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+" ");
            curr=curr.next;
        }System.out.println();
    }
}

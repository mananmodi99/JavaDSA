package LeetcodeProblems;

public class RemoveNthNodeFromBack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        if(head.next == null && n==1) return null;
        ListNode tail = head;
        int count = 0;
        while(tail!=null){
            count++;
            tail= tail.next;
        }
        if(n == count){//[1,2], 2-->[1]
            head = head.next;
            return head;
        }
        int idx = count - n - 1;
        ListNode curr = head;

        while(idx>0){
            curr = curr.next;
            idx--;
        }

        curr.next = curr.next.next;
        return head;
    }
    public ListNode EfficientremoveNthFromEnd(ListNode head, int n) {
        //One traversal only
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast_p = dummy;
        ListNode slow_p = dummy;
        for(int i = 1; i<=n; i++){
            fast_p = fast_p.next;
        }
        while(fast_p.next!=null){
            fast_p = fast_p.next;
            slow_p = slow_p.next;
        }
        slow_p.next = slow_p.next.next;
        return head;
    }
}

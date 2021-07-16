package LeetcodeProblems;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow_p = head;
        ListNode fast_p = head;
        while(fast_p.next != null && fast_p.next.next != null){
            fast_p = fast_p.next.next;
            slow_p = slow_p.next;
            if(slow_p == fast_p) break;

        }
        if(fast_p.next == null) return null;
        if(fast_p.next.next == null) return null;
        slow_p = head;
        while(slow_p != fast_p){
            slow_p = slow_p.next;
            fast_p = fast_p.next;
        }
        return slow_p;
    }
    public static void main(String[] args) {
        LinkedListCycleII pd = new LinkedListCycleII();
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(pd.detectCycle(head).val);
    }
}

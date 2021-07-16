package LeetcodeProblems;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle cyc = new LinkedListCycle();
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        System.out.println(cyc.hasCycle(head));
    }
    public boolean hasCycle(ListNode head) {
        if( head == null || head.next == null ) return false;
        ListNode temp1x = head, temp2x = head;
        while(temp2x.next != null && temp2x.next.next != null){
            temp1x = temp1x.next;
            temp2x = temp2x.next.next;
            if(temp1x == temp2x) return true;
        }
        return false;
    }
}
